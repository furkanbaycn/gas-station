package com.example.furkanbaycan.gasstation.HTTPParser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LPGParser {
    List<DataModel> dataModelList = new ArrayList<DataModel>();

    public List<DataModel> getLPG(String html) {

        Pattern pAkpet = Pattern.compile(".*<img src=\"/images/sirketler/(.*?)\" alt=\"(.*?)\" width=\"85\" height=\"30\"/></td><td class=\"grid-fiyatlar-sutun2\"><span>(.*?)</span></td>.*");
        Matcher mAkpet = pAkpet.matcher(html);
        while(mAkpet.find()) {
            dataModelList.add(new DataModel("" + mAkpet.group(2),"" + mAkpet.group(3),""));
        }

        return dataModelList;
    }
}
