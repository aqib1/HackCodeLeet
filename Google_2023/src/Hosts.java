import java.util.HashMap;

public class Hosts {

    private static HashMap<String, Integer> hostCount = new HashMap<>();

    public static HashMap<String, String> hostByRequestId(String val) {
        val = val.replaceAll("\\[", "");
        val = val.replaceAll("]", "");
        val = val.replaceAll("\"", "");
        val = val.replaceAll(" ", "");
        String[] data = val.split("\n");
        HashMap<String, String> map = new HashMap<>();
        for(String d: data) {
            if(d!= null && !d.isBlank()) {
                String[] subData = d.split(":");
                map.put(subData[0], subData[1].split(",")[0]);
                if(hostCount.containsKey(subData[0])) {
                    hostCount.put(subData[0], hostCount.get(subData[0]) + 1);
                } else {
                    hostCount.put(subData[0], 1);
                }
            }
        }
        return map;
    }
    public static void main(String[] args) {
      HashMap<String, String> data =  hostByRequestId(
                        "[\n" +
                                "  \"s3-prod-s3ws-nlb-iad1-u96-p1-1011.iad1.amazon.com: 9B71FZ7B6XZ7FYJW, S3.GET.OBJECT\",\n" +
                                "  \"s3-prod-s3ws-nlb-iad1-u96-p1-1011.iad1.amazon.com: 9B759ZFXJPM1NNAZ, S3.PUT.OBJECT\",\n" +
                                "  \"s3-prod-s3ws-nlb-iad1-u89-p1-1011.iad1.amazon.com: AVP64RQ2TCWT8SE8, S3.PUT.OBJECT\",\n" +
                                "  \"s3-prod-s3ws-nlb-iad1-u89-p1-1011.iad1.amazon.com: AVP86N9CVRCFFMET, S3.GET.OBJECT\",\n" +
                                "  \"s3-prod-s3ws-nlb-iad1-u108-p1-1008.iad1.amazon.com: HQ6FTR2361DS261Y, S3.GET.OBJECT\",\n" +
                                "  \"s3-prod-s3ws-nlb-iad1-u108-p1-1008.iad1.amazon.com: HQ61VN7FKKBB1ERM, S3.PUT.OBJECT\",\n" +
                                "  \"s3-prod-s3ws-j107-r3-25007.iad12.amazon.com: WRGGZTN0VVQRAEGY, S3.PUT.OBJECT\",\n" +
                                "  \"s3-prod-s3ws-nlb-iad1-u79-p1-1011.iad1.amazon.com: 0WE5RR0Y0SFKPVDM, S3.GET.OBJECT\",\n" +
                                "  \"s3-prod-s3ws-nlb-iad1-u79-p1-1011.iad1.amazon.com: 0WEC2DTEQMBD7SJN, S3.PUT.OBJECT\",\n" +
                                "  \"s3-prod-s3ws-nlb-iad1-u103-p1-1008.iad1.amazon.com: FKRMT1HJRTR76WAM, S3.GET.OBJECT\",\n" +
                                "  \"s3-prod-s3ws-nlb-iad1-u103-p1-1008.iad1.amazon.com: FKRMYY13PVWB85WS, S3.PUT.OBJECT\",\n" +
                                "  \"s3-prod-s3ws-nlb-iad1-u68-p1-1011.iad1.amazon.com: 9B7DP7WSAMBASAB7, S3.GET.OBJECT\",\n" +
                                "  \"s3-prod-s3ws-nlb-iad1-u68-p1-1011.iad1.amazon.com: 9B75ZH3VR1P3GT92, S3.PUT.OBJECT\",\n" +
                                "  \"s3-prod-s3ws-nlb-iad7-u111-p1-7047.iad7.amazon.com: 9B7E36QNPR50H1JH, S3.GET.OBJECT\",\n" +
                                "  \"s3-prod-s3ws-nlb-iad7-u111-p1-7047.iad7.amazon.com: 9B75JSB0AZ2TDXWF, S3.PUT.OBJECT\",\n" +
                                "  \"s3-prod-s3ws-nlb-iad7-u133-p1-7026.iad7.amazon.com: FKRG268J77NC7ED1, S3.GET.OBJECT\",\n" +
                                "  \"s3-prod-s3ws-nlb-iad7-u133-p1-7026.iad7.amazon.com: FKRVKYB5PWDZ4CKZ, S3.PUT.OBJECT\",\n" +
                                "  \"s3-prod-s3ws-nlb-iad7-u103-p1-7048.iad7.amazon.com: FKRNNJYYCN80KZN4, S3.GET.OBJECT\",\n" +
                                "  \"s3-prod-s3ws-nlb-iad7-u103-p1-7048.iad7.amazon.com: FKRSEM4ENNX6K278, S3.PUT.OBJECT\",\n" +
                                "  \"s3-prod-s3ws-j375-r2-25012.iad12.amazon.com: XMCTNHK0J8D9YZVJ, S3.PUT.OBJECT\",\n" +
                                "  \"s3-prod-s3ws-nlb-iad1-u98-p1-1008.iad1.amazon.com: CH9S9M19ZHQJMP99, S3.GET.OBJECT\",\n" +
                                "  \"s3-prod-s3ws-nlb-iad1-u98-p1-1008.iad1.amazon.com: CH9HBPYFEMAQAXPX, S3.PUT.OBJECT\",\n" +
                                "  \"s3-prod-s3ws-j375-r2-25012.iad12.amazon.com: XMCS5BYZRQYPZ4GE, S3.GET.OBJECT\",\n" +
                                "  \"s3-prod-s3ws-nlb-iad1-u107-p1-1008.iad1.amazon.com: 8P2JS8YKGJN0H46A, S3.PUT.OBJECT\",\n" +
                                "  \"s3-prod-s3ws-nlb-iad1-u107-p1-1008.iad1.amazon.com: 8P2YE8VCM2BT558C, S3.GET.OBJECT\",\n" +
                                "  \"s3-prod-s3ws-nlb-iad1-u100-p1-1012.iad1.amazon.com: 169YC9Q0SD1Q568X, S3.GET.OBJECT\",\n" +
                                "  \"s3-prod-s3ws-nlb-iad1-u100-p1-1012.iad1.amazon.com: 169WN4F2RXAJN864, S3.PUT.OBJECT\",\n" +
                                "  \"s3-prod-s3ws-j375-r2-25007.iad12.amazon.com: RQ21V1SMTT823PE0, S3.GET.OBJECT\",\n" +
                                "  \"s3-prod-s3ws-j375-r2-25007.iad12.amazon.com: RQ241HAMK4DWZN75, S3.PUT.OBJECT\",\n" +
                                "  \"s3-prod-s3ws-nlb-iad7-u109-p1-7047.iad7.amazon.com: 68NYFZMD8MSACN9P, S3.GET.OBJECT\",\n" +
                                "  \"s3-prod-s3ws-nlb-iad7-u109-p1-7047.iad7.amazon.com: 8P2GB4E8W32TJV9D, S3.PUT.OBJECT\",\n" +
                                "  \"s3-prod-s3ws-nlb-iad7-u100-p1-7047.iad7.amazon.com: 68NRSQZ9KV0Z4NC1, S3.GET.OBJECT\",\n" +
                                "  \"s3-prod-s3ws-nlb-iad7-u100-p1-7047.iad7.amazon.com: 8P2NJP6MK98T54XJ, S3.PUT.OBJECT\"\n" +
                                "]\n" +
                                "[\n" +
                                "  \"s3-prod-s3ws-j107-r3-25007.iad12.amazon.com: YCV2GAMPV5GQPSY7, S3.GET.OBJECT\",\n" +
                                "  \"s3-prod-s3ws-j107-r3-25007.iad12.amazon.com: YCV6QHGYFG1EPJJ3, S3.PUT.OBJECT\",\n" +
                                "  \"s3-prod-s3ws-nlb-iad7-u115-p1-7050.iad7.amazon.com: 8P6TWNX7SFXM4CV5, S3.GET.OBJECT\",\n" +
                                "  \"s3-prod-s3ws-nlb-iad7-u115-p1-7050.iad7.amazon.com: 8P6WV046WRHBBD8Z, S3.PUT.OBJECT\",\n" +
                                "  \"s3-prod-s3ws-nlb-iad7-u107-p1-7050.iad7.amazon.com: YCV5BM3E33DK77YP, S3.PUT.OBJECT\",\n" +
                                "  \"s3-prod-s3ws-nlb-iad7-u107-p1-7050.iad7.amazon.com: YCVEAQ3Z8KRPK369, S3.GET.OBJECT\",\n" +
                                "  \"s3-prod-s3ws-nlb-iad7-u120-p1-7052.iad7.amazon.com: GS3181MFWJDV303T, S3.PUT.OBJECT\",\n" +
                                "  \"s3-prod-s3ws-nlb-iad7-u122-p1-7048.iad7.amazon.com: YCVEFYHVE0CN9PWH, S3.PUT.OBJECT\",\n" +
                                "  \"s3-prod-s3ws-j375-r2-25007.iad12.amazon.com: GS3FYA49P0P82SY5, S3.PUT.OBJECT\",\n" +
                                "  \"s3-prod-s3ws-j375-r2-25007.iad12.amazon.com: GS37PXXJW42KXERK, S3.GET.OBJECT\",\n" +
                                "  \"s3-prod-s3ws-nlb-iad7-u114-p1-7048.iad7.amazon.com: 3JAZB8Q52E0KBBQF, S3.PUT.OBJECT\",\n" +
                                "  \"s3-prod-s3ws-nlb-iad7-u114-p1-7048.iad7.amazon.com: 3JATH937A4V27KEX, S3.GET.OBJECT\",\n" +
                                "  \"s3-prod-s3ws-nlb-iad7-u113-p1-7048.iad7.amazon.com: YCV6D1C38XNSQYGM, S3.PUT.OBJECT\",\n" +
                                "  \"s3-prod-s3ws-nlb-iad7-u113-p1-7048.iad7.amazon.com: YCV8MDGY5MMSHA08, S3.GET.OBJECT\",\n" +
                                "  \"s3-prod-s3ws-nlb-iad7-u112-p1-7048.iad7.amazon.com: 8P6HR7883ZTA5FFV, S3.PUT.OBJECT\",\n" +
                                "  \"s3-prod-s3ws-nlb-iad7-u112-p1-7048.iad7.amazon.com: 8P6MX82Z8X38QMVD, S3.GET.OBJECT\",\n" +
                                "  \"s3-prod-s3ws-j375-r2-25012.iad12.amazon.com: VTGSQ6HAT4HPGCRW, S3.GET.OBJECT\",\n" +
                                "  \"s3-prod-s3ws-j375-r2-25012.iad12.amazon.com: VTGS1F81V1TN9E65, S3.PUT.OBJECT\",\n" +
                                "  \"s3-prod-s3ws-nlb-iad7-u118-p1-7051.iad7.amazon.com: ENRVVPA5QMAC9M0M, S3.GET.OBJECT\",\n" +
                                "  \"s3-prod-s3ws-nlb-iad7-u118-p1-7051.iad7.amazon.com: ENRMX8DRAHHX7VD2, S3.PUT.OBJECT\",\n" +
                                "  \"s3-prod-s3ws-nlb-iad7-u119-p1-7048.iad7.amazon.com: 3JAV20X6HXYKR288, S3.GET.OBJECT\",\n" +
                                "  \"s3-prod-s3ws-nlb-iad7-u119-p1-7048.iad7.amazon.com: 3JAW10X4J0HNQWBF, S3.PUT.OBJECT\",\n" +
                                "  \"s3-prod-s3ws-nlb-iad7-u108-p1-7048.iad7.amazon.com: 7JP73CG8HKVYFC14, S3.PUT.OBJECT\",\n" +
                                "  \"s3-prod-s3ws-nlb-iad7-u108-p1-7048.iad7.amazon.com: 7JP8PDGKTVG9EN5C, S3.GET.OBJECT\"\n" +
                                "]\n" +
                                "[\n" +
                                "  \"s3-prod-s3ws-j375-r2-25007.iad12.amazon.com: YJ578PMK1TED9QTC, S3.GET.OBJECT\",\n" +
                                "  \"s3-prod-s3ws-j375-r2-25007.iad12.amazon.com: R22M6AS7KRMWZNCA, S3.PUT.OBJECT\",\n" +
                                "  \"s3-prod-s3ws-j375-r2-25012.iad12.amazon.com: BFDCCANX55Z5J0VE, S3.PUT.OBJECT\",\n" +
                                "  \"s3-prod-s3ws-j375-r2-25012.iad12.amazon.com: BFDDT2C3SZ55Y1HQ, S3.GET.OBJECT\",\n" +
                                "  \"s3-prod-s3ws-j107-r3-25007.iad12.amazon.com: 29J3YA0MJ65AYG87, S3.GET.OBJECT\",\n" +
                                "  \"s3-prod-s3ws-j107-r3-25007.iad12.amazon.com: 29JCYHKPA21SJGNX, S3.PUT.OBJECT\"\n" +
                                "]\n"
        );


//      for (String key: data.keySet()) {
//          System.out.println(key +" , " + data.get(key));
//      }


        for (String key: hostCount.keySet()) {
            System.out.println(key +" , " + hostCount.get(key));
        }
    }
}
