/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.List;
import java.util.Map;
import kereskedelem.aru.Cikk;

/**
 *
 * @author igloi
 */
public class SajatViewModel implements ArukeresoView{

    @Override
    public Object createView(Map<String, Object> parameterek) {
        String htmlSablon = (String)parameterek.get("htmlSablon");
        List<Cikk> cikkek = (List<Cikk>)parameterek.get("cikkek");
        
        Map<String, String[]> reqparams = (Map<String, String[]>) parameterek.get("parameterek");
        
        String megnevezes = reqparams.get("megnevezes") != null ? reqparams.get("megnevezes")[0] : "";
        int minar = reqparams.get("minAr") != null ? Integer.parseInt(reqparams.get("minAr")[0]) : 0;
        int maxar = reqparams.get("maxAr") != null ? Integer.parseInt(reqparams.get("maxAr")[0]) : 0;
        
        String tablaSorok = cikkekView(cikkek);
        String megyseg = megysegView((String[])parameterek.get("megysegek"), reqparams.get("megyseg"));
        
        htmlSablon = htmlSablon.replace("${cikkek}", tablaSorok);
        htmlSablon = htmlSablon.replace("${megysegek}", megyseg);
        htmlSablon = htmlSablon.replace("${megnevezes}", megnevezes);
        htmlSablon = htmlSablon.replace("${minAr}", Integer.toString(minar));
        htmlSablon = htmlSablon.replace("${maxAr}", Integer.toString(maxar));
        htmlSablon = htmlSablon.replace("${megysegekSzama}", 
                Integer.toString(((String[])parameterek.get("megysegek")).length));
        
        return htmlSablon;
    }

    private String cikkekView(List<Cikk> cikkek) {
        StringBuilder sbTablaSorok = new StringBuilder();
        sbTablaSorok.append("<tbody>");
        for (Cikk c : cikkek) {
            sbTablaSorok.append("<tr>");
            sbTablaSorok.append("<td>").append(c.getCikkszam()).append("</td>");
            sbTablaSorok.append("<td>").append(c.getMegnevezes()).append("</td>");
            sbTablaSorok.append("<td>").append(c.getMennyisegiEgyseg()).append("</td>");
            sbTablaSorok.append("<td>").append(c.getAfakulcs()).append("</td>");
            sbTablaSorok.append("<td>").append(c.getEladasiAr()).append("</td>");
            sbTablaSorok.append("<td>").append(c.getKeszlet()).append("</td>");
            sbTablaSorok.append("</tr>");
        }
        sbTablaSorok.append("</tbody>");
        return sbTablaSorok.toString();
    }
    
    
    private String megysegView(String[] egysegek, String[] kijelolt) {
        StringBuilder sb = new StringBuilder();
        for(String s: egysegek) {
            sb.append("<option value=\"").
                    append(s).append("\"");
            if(kijelolt != null) {
                for(String ks: kijelolt) {
                    if(ks.equals(s)) {
                        sb.append(" selected");
                    }
                }
            }
            sb.append(">").
                    append(s).
                    append("</option>");
        }
        
        return sb.toString();
    }
}
