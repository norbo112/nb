package view;

import java.util.Map;

public interface ArukeresoView {

    /**
     * Tetszőleges típusú paraméterek táblázata. Pl.
     *      parameterek: Map&ltString, String[]&gt //request.parameterMap
     *      cikkek: List&ltCikk&gt //cikkek listája
     *      megysegek: String[] //mennyiségi egységek tömbje
     *      htmlSablon: String //htmlSablon szövege
     * @param parameterek
     * @return a view objektum, pl. html szöveg 
     */
    Object createView(Map<String, Object> parameterek);
}
