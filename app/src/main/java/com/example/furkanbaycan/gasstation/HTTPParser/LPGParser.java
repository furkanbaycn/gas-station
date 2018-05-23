package com.example.furkanbaycan.gasstation.HTTPParser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LPGParser {
    List<DataModel> dataModelList = new ArrayList<DataModel>();

    public List<DataModel> getLPG(String html) {

        Pattern pAkpet = Pattern.compile(".*<img src=\"/images/sirketler/akpet.png\" alt=\"(.*?)\" width=\"85\" height=\"30\"/></td><td class=\"grid-fiyatlar-sutun2\"><span>(.*?)</span></td>.*");
        Matcher mAkpet = pAkpet.matcher(html);
        while(mAkpet.find()) {
            dataModelList.add(new DataModel("" + mAkpet.group(1),"" + mAkpet.group(2),""));
        }

        Pattern pPO = Pattern.compile(".*<img src=\"/images/sirketler/petrol-ofisi.png\" alt=\"(.*?)\" width=\"85\" height=\"30\"/></td><td class=\"grid-fiyatlar-sutun2\"><span>(.*?)</span></td>.*");
        Matcher mPO = pPO.matcher(html);
        while(mPO.find()) {
            dataModelList.add(new DataModel("" + mPO.group(1),"" + mPO.group(2),""));
        }

        Pattern pTotal = Pattern.compile(".*<img src=\"/images/sirketler/total.png\" alt=\"(.*?)\" width=\"85\" height=\"30\"/></td><td class=\"grid-fiyatlar-sutun2\"><span>(.*?)</span></td>.*");
        Matcher mTotal = pTotal.matcher(html);
        while(mTotal.find()) {
            dataModelList.add(new DataModel("" + mTotal.group(1),"" + mTotal.group(2),""));
        }

        Pattern pBP = Pattern.compile(".*<img src=\"/images/sirketler/bp.png\" alt=\"(.*?)\" width=\"85\" height=\"30\"/></td><td class=\"grid-fiyatlar-sutun2\"><span>(.*?)</span></td>.*");
        Matcher mBP = pBP.matcher(html);
        while(mBP.find()) {
            dataModelList.add(new DataModel("" + mBP.group(1),"" + mBP.group(2),""));
        }

        Pattern pShell = Pattern.compile(".*<img src=\"/images/sirketler/shell.png\" alt=\"(.*?)\" width=\"85\" height=\"30\"/></td><td class=\"grid-fiyatlar-sutun2\"><span>(.*?)</span></td>.*");
        Matcher mShell = pShell.matcher(html);
        while(mShell.find()) {
            dataModelList.add(new DataModel("" + mShell.group(1),"" + mShell.group(2),""));
        }

        Pattern pAytemiz = Pattern.compile(".*<img src=\"/images/sirketler/aytemiz.png\" alt=\"(.*?)\" width=\"85\" height=\"30\"/></td><td class=\"grid-fiyatlar-sutun2\"><span>(.*?)</span></td>.*");
        Matcher mAytemiz = pAytemiz.matcher(html);
        while(mAytemiz.find()) {
            dataModelList.add(new DataModel("" + mAytemiz.group(1),"" + mAytemiz.group(2),""));
        }

        Pattern pAygaz = Pattern.compile(".*<img src=\"/images/sirketler/aygaz.png\" alt=\"(.*?)\" width=\"85\" height=\"30\"/></td><td class=\"grid-fiyatlar-sutun2\"><span>(.*?)</span></td>.*");
        Matcher mAygaz = pAygaz.matcher(html);
        while(mAygaz.find()) {
            dataModelList.add(new DataModel("" + mAygaz.group(1),"" + mAygaz.group(2),""));
        }

        Pattern pMilan = Pattern.compile(".*<img src=\"/images/sirketler/milangaz.png\" alt=\"(.*?)\" width=\"85\" height=\"30\"/></td><td class=\"grid-fiyatlar-sutun2\"><span>(.*?)</span></td>.*");
        Matcher mMilan = pMilan.matcher(html);
        while(mMilan.find()) {
            dataModelList.add(new DataModel("" + mMilan.group(1),"" + mMilan.group(2),""));
        }

        Pattern pMogaz = Pattern.compile(".*<img src=\"/images/sirketler/mogaz.png\" alt=\"(.*?)\" width=\"85\" height=\"30\"/></td><td class=\"grid-fiyatlar-sutun2\"><span>(.*?)</span></td>.*");
        Matcher mMogaz = pMogaz.matcher(html);
        while(mMogaz.find()) {
            dataModelList.add(new DataModel("" + mMogaz.group(1),"" + mMogaz.group(2),""));
        }

        Pattern pIpra = Pattern.compile(".*<img src=\"/images/sirketler/ipragaz.png\" alt=\"(.*?)\" width=\"85\" height=\"30\"/></td><td class=\"grid-fiyatlar-sutun2\"><span>(.*?)</span></td>.*");
        Matcher mIpra = pIpra.matcher(html);
        while(mIpra.find()) {
            dataModelList.add(new DataModel("" + mIpra.group(1),"" + mIpra.group(2),""));
        }




        return dataModelList;
    }
}
