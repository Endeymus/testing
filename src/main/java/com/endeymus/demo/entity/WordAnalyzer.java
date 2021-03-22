package com.endeymus.demo.entity;

import lombok.Getter;
import org.springframework.stereotype.Component;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Класс реализующий основную логику обработки входящего слова
 * @author Mark Shamray
 */
@Getter
@Component
public class WordAnalyzer {

    private final Letter letter = new Letter();

    /**
     * Заполнение класса {@link com.endeymus.demo.entity.Letter} полученными значениями
     * @param word - слово которое необходимо проанализировать
     */
    public void find(String word) {
        Map<Character, Integer> keys = count(word);
        Map.Entry<Character, Integer> max = max(keys);
        letter.setLetter(max.getKey());
        letter.setCount(max.getValue());
    }

    /**
     * Подсчет количества символов
     * @param word - слово которое необходимо проанализировать
     * @return карта {@link java.util.Map}
     */
    private Map<Character, Integer> count(String word) {
        Map<Character, Integer> keys = new LinkedHashMap<>();

        for (int i = 0; i < word.length(); i++) {
            char symbol = word.charAt(i);
            if (keys.containsKey(symbol)) {
                keys.put(symbol, keys.get(symbol) + 1);
            } else {
                keys.put(symbol, 1);
            }
        }
        /*        keys.forEach((k,v) -> {
            System.out.println(k + " : " + v);
        });*/
        return keys;
    }

    /**
     * Ищет в карте букву встречающуюся максимальное количество раз
     * @param map - карта с подсчитанным количеством символов
     * @return набор {@link java.util.Map.Entry}
     */
    private Map.Entry<Character, Integer> max(Map<Character, Integer> map) {
        Map.Entry<Character, Integer> max = null;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (max == null || entry.getValue().compareTo(max.getValue()) >= 0)
                max = entry;
        }
        return max;
    }
}
