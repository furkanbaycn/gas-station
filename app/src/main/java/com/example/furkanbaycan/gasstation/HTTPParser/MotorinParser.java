package com.example.furkanbaycan.gasstation.HTTPParser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MotorinParser {
    List<DataModel> dataModelList = new ArrayList<DataModel>();

    public List<DataModel> getMotorin(String html) {
        Pattern pMoil = Pattern.compile(".*<td class=\"grid-fiyatlar-sutun1\" align=\"center\" width=\"34%\"><img src=\"/images/sirketler/moil.png\" alt=\"(.*?)\" width=\"85\" height=\"30\"/></td><td class=\"grid-fiyatlar-sutun2\" width=\"33%\">(.*?)</td><td class=\"grid-fiyatlar-sutun2\" width=\"33%\">(.*?)</td>.*");
        Matcher mMoil = pMoil.matcher(html);
        while(mMoil.find()) {
            dataModelList.add(new DataModel("" + mMoil.group(1),"" + mMoil.group(2),"" + mMoil.group(3)));
        }

        Pattern pAlpet = Pattern.compile(".*<td class=\"grid-fiyatlar-sutun1\" align=\"center\" width=\"34%\"><img src=\"/images/sirketler/alpet.png\" alt=\"(.*?)\" width=\"85\" height=\"30\"/></td><td class=\"grid-fiyatlar-sutun2\" width=\"33%\">(.*?)</td><td class=\"grid-fiyatlar-sutun2\" width=\"33%\">(.*?)</td>.*");
        Matcher mAlpet = pAlpet.matcher(html);
        while(mAlpet.find()) {
            dataModelList.add(new DataModel("" + mAlpet.group(1),"" + mAlpet.group(2),"" + mAlpet.group(3)));
        }

        Pattern pLukoil = Pattern.compile(".*<td class=\"grid-fiyatlar-sutun1\" align=\"center\" width=\"34%\"><img src=\"/images/sirketler/lukoil.png\" alt=\"(.*?)\" width=\"85\" height=\"30\"/></td><td class=\"grid-fiyatlar-sutun2\" width=\"33%\">(.*?)</td><td class=\"grid-fiyatlar-sutun2\" width=\"33%\">(.*?)</td>.*");
        Matcher mLukoil = pLukoil.matcher(html);
        while(mLukoil.find()) {
            dataModelList.add(new DataModel("" + mLukoil.group(1),"" + mLukoil.group(2),"" + mLukoil.group(3)));
        }

        Pattern pOpet = Pattern.compile(".*<td class=\"grid-fiyatlar-sutun1\" align=\"center\" width=\"34%\"><img src=\"/images/sirketler/opet.png\" alt=\"(.*?)\" width=\"85\" height=\"30\"/></td><td class=\"grid-fiyatlar-sutun2\" width=\"33%\">(.*?)</td><td class=\"grid-fiyatlar-sutun2\" width=\"33%\">(.*?)</td>.*");
        Matcher mOpet = pOpet.matcher(html);
        while(mOpet.find()) {
            dataModelList.add(new DataModel("" + mOpet.group(1),"" + mOpet.group(2),"" + mOpet.group(3)));
        }

        Pattern pPO = Pattern.compile(".*<td class=\"grid-fiyatlar-sutun1\" align=\"center\" width=\"34%\"><img src=\"/images/sirketler/petrol-ofisi.png\" alt=\"(.*?)\" width=\"85\" height=\"30\"/></td><td class=\"grid-fiyatlar-sutun2\" width=\"33%\">(.*?)</td><td class=\"grid-fiyatlar-sutun2\" width=\"33%\">(.*?)</td>.*");
        Matcher mPO = pPO.matcher(html);
        while(mPO.find()) {
            dataModelList.add(new DataModel("" + mPO.group(1),"" + mPO.group(2),"" + mPO.group(3)));
        }

        Pattern pTotal = Pattern.compile(".*<td class=\"grid-fiyatlar-sutun1\" align=\"center\" width=\"34%\"><img src=\"/images/sirketler/total.png\" alt=\"(.*?)\" width=\"85\" height=\"30\"/></td><td class=\"grid-fiyatlar-sutun2\" width=\"33%\">(.*?)</td><td class=\"grid-fiyatlar-sutun2\" width=\"33%\">(.*?)</td>.*");
        Matcher mTotal = pTotal.matcher(html);
        while(mTotal.find()) {
            dataModelList.add(new DataModel("" + mTotal.group(1),"" + mTotal.group(2),"" + mTotal.group(3)));
        }

        Pattern pBP = Pattern.compile(".*<td class=\"grid-fiyatlar-sutun1\" align=\"center\" width=\"34%\"><img src=\"/images/sirketler/bp.png\" alt=\"(.*?)\" width=\"85\" height=\"30\"/></td><td class=\"grid-fiyatlar-sutun2\" width=\"33%\">(.*?)</td><td class=\"grid-fiyatlar-sutun2\" width=\"33%\">(.*?)</td>.*");
        Matcher mBP = pBP.matcher(html);
        while(mBP.find()) {
            dataModelList.add(new DataModel("" + mBP.group(1),"" + mBP.group(2),"" + mBP.group(3)));
        }

        Pattern pShell = Pattern.compile(".*<td class=\"grid-fiyatlar-sutun1\" align=\"center\" width=\"34%\"><img src=\"/images/sirketler/shell.png\" alt=\"(.*?)\" width=\"85\" height=\"30\"/></td><td class=\"grid-fiyatlar-sutun2\" width=\"33%\">(.*?)</td><td class=\"grid-fiyatlar-sutun2\" width=\"33%\">(.*?)</td>.*");
        Matcher mShell = pShell.matcher(html);
        while(mShell.find()) {
            dataModelList.add(new DataModel("" + mShell.group(1),"" + mShell.group(2),"" + mShell.group(3)));
        }

        return dataModelList;
    }

}
