package com.example.furkanbaycan.gasstation.HTTPParser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BenzinParser {
    List<DataModel> dataModelList = new ArrayList<DataModel>();

    public List<DataModel> getBenzin(String html) {
        System.out.println("BenzinParser Çalıştı");
        Pattern pMoil = Pattern.compile(".*<td class=\"grid-fiyatlar-sutun1\" align=\"center\" width=\"34%\"><img src=\"/images/sirketler/(.*?)\" alt=\"(.*?)\" width=\"85\" height=\"30\"/></td><td class=\"grid-fiyatlar-sutun2\" width=\"33%\">(.*?)</td><td class=\"grid-fiyatlar-sutun2\" width=\"33%\">(.*?)</td>.*");
        Matcher mMoil = pMoil.matcher(html);
        while(mMoil.find()) {
            dataModelList.add(new DataModel("" + mMoil.group(2),"" + mMoil.group(3),"" + mMoil.group(4)));
        }
        return dataModelList;
    }
}
