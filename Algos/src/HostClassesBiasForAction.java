package com.test.web3labs;

import java.util.*;

public class HostClassesBiasForAction {

    private static final Map<String, Integer> hostCount = new HashMap<>();
    public static Map<String, List<String>> hostsByOperation(List<String> data) {
        Map<String, List<String>> map = new HashMap<>();

       data.forEach(d -> {
           String [] raw = d.split(",");
           String host = raw[0].split(":")[0];
           if(map.containsKey(raw[1])) {
               map.get(raw[1]).add(host);
           } else {
               map.put(raw[1], new ArrayList<>(List.of(host)));
           }

           if(hostCount.containsKey(host)) {
               hostCount.put(host, hostCount.get(host) + 1);
           } else {
               hostCount.put(host, 1);
           }
       });

        return map;
    }

    public static void main(String[] args) {
        List<String> data = List.of(
                "s3-prod-s3ws-nlb-iad7-u99-p1-7013.iad7.amazon.com: DCQTD8ZGQR3SRKJ4, S3.PUT.OBJECT","s3-prod-s3ws-nlb-iad7-u99-p1-7013.iad7.amazon.com: DCQKR2X4427NAM5Y, S3.GET.OBJECT","s3-prod-s3ws-nlb-iad7-u99-p1-7028.iad7.amazon.com: K90163DVM6P4YNK8, S3.GET.OBJECT","s3-prod-s3ws-nlb-iad7-u99-p1-7028.iad7.amazon.com: K903S9KZN5HPBEHZ, S3.PUT.OBJECT","s3-prod-s3ws-nlb-iad7-u99-p1-7041.iad7.amazon.com: RTV5960SSNCK986Q, S3.GET.OBJECT","s3-prod-s3ws-nlb-iad7-u99-p1-7041.iad7.amazon.com: QYG69W7JWVAN3TBF, S3.PUT.OBJECT","s3-prod-s3ws-nlb-iad7-u99-p1-7004.iad7.amazon.com: 6Y0G88GN0DJYTTY3, S3.PUT.OBJECT","s3-prod-s3ws-nlb-iad7-u99-p1-7004.iad7.amazon.com: 6Y0NHP36DFS69T5M, S3.GET.OBJECT","s3-prod-s3ws-nlb-iad7-u99-p1-7032.iad7.amazon.com: P9EYM8V7B57PCW89, S3.GET.OBJECT","s3-prod-s3ws-nlb-iad7-u99-p1-7032.iad7.amazon.com: P9EYJWXY6A69WP4Z, S3.PUT.OBJECT","s3-prod-s3ws-nlb-iad7-u99-p1-7006.iad7.amazon.com: 6Y0TWENVRFSDGFQ5, S3.GET.OBJECT","s3-prod-s3ws-nlb-iad7-u99-p1-7006.iad7.amazon.com: 6Y0PE5S7VRHF5NAS, S3.PUT.OBJECT","s3-prod-s3ws-nlb-iad7-u99-p1-7003.iad7.amazon.com: P9EJ33BF4E50RT34, S3.PUT.OBJECT","s3-prod-s3ws-nlb-iad7-u99-p1-7003.iad7.amazon.com: AZP6JNXD3Q21MQDX, S3.GET.OBJECT","s3-prod-s3ws-nlb-iad7-u99-p1-7034.iad7.amazon.com: 6MRJKE59R6A2B283, S3.GET.OBJECT","s3-prod-s3ws-nlb-iad7-u99-p1-7034.iad7.amazon.com: 6MRN663R80WGA5WS, S3.PUT.OBJECT","s3-prod-s3ws-nlb-iad7-u99-p1-7011.iad7.amazon.com: DCQZA51DZFJQ9GBE, S3.GET.OBJECT","s3-prod-s3ws-nlb-iad7-u99-p1-7011.iad7.amazon.com: DCQTVNC0HS6XFR6B, S3.PUT.OBJECT","s3-prod-s3ws-nlb-iad7-u99-p1-7035.iad7.amazon.com: P9EHZKFVW67TKS0C, S3.PUT.OBJECT","s3-prod-s3ws-nlb-iad7-u99-p1-7035.iad7.amazon.com: P9EWB6EPWCBF6R4E, S3.GET.OBJECT","s3-prod-s3ws-nlb-iad7-u99-p1-7001.iad7.amazon.com: 6Y0WKSY08Q4YWDPN, S3.GET.OBJECT","s3-prod-s3ws-nlb-iad7-u99-p1-7001.iad7.amazon.com: 6Y0S6AC7VB8BYH54, S3.PUT.OBJECT","s3-prod-s3ws-nlb-iad7-u99-p1-7024.iad7.amazon.com: AZPCAZTWPWADV4AT, S3.GET.OBJECT","s3-prod-s3ws-nlb-iad7-u99-p1-7024.iad7.amazon.com: AZPBBPBQ3P36BCRQ, S3.PUT.OBJECT","s3-prod-s3ws-nlb-iad7-u99-p1-7031.iad7.amazon.com: KYPK31VC1VAJH1DA, S3.GET.OBJECT","s3-prod-s3ws-nlb-iad7-u99-p1-7020.iad7.amazon.com: 163WQB854GDPNDAR, S3.GET.OBJECT","s3-prod-s3ws-nlb-iad7-u99-p1-7020.iad7.amazon.com: 163NAR5K53K8S69C, S3.PUT.OBJECT","s3-prod-s3ws-nlb-iad7-u99-p1-7031.iad7.amazon.com: 8TNKZZABB956EJKG, S3.PUT.OBJECT","s3-prod-s3ws-nlb-iad7-u99-p1-7026.iad7.amazon.com: G8FHYCDH9Y9PFW0Q, S3.PUT.OBJECT","s3-prod-s3ws-nlb-iad7-u99-p1-7026.iad7.amazon.com: G8FH5XTCD9BG5Q2A, S3.GET.OBJECT","s3-prod-s3ws-nlb-iad7-u99-p1-7023.iad7.amazon.com: H5DFD4C31RMKMFQS, S3.GET.OBJECT","s3-prod-s3ws-nlb-iad7-u99-p1-7023.iad7.amazon.com: H5D7FNE7J1KK9RVC, S3.PUT.OBJECT","s3-prod-s3ws-nlb-iad7-u99-p1-7029.iad7.amazon.com: TZCEG73GXNW3AHGG, S3.GET.OBJECT","s3-prod-s3ws-nlb-iad7-u99-p1-7029.iad7.amazon.com: TZC2VH0T0FTNATD3, S3.PUT.OBJECT","s3-prod-s3ws-nlb-iad7-u99-p1-7030.iad7.amazon.com: ZZQM18RFWRMTG54A, S3.GET.OBJECT","s3-prod-s3ws-nlb-iad7-u99-p1-7030.iad7.amazon.com: ZZQYTV2WMJX92EXQ, S3.PUT.OBJECT","s3-prod-s3ws-nlb-iad7-u99-p1-7017.iad7.amazon.com: G8FJTEFFSERQ1S1T, S3.PUT.OBJECT","s3-prod-s3ws-nlb-iad7-u99-p1-7017.iad7.amazon.com: G8FQS4A4H4XCBD1R, S3.GET.OBJECT","s3-prod-s3ws-nlb-iad7-u99-p1-7018.iad7.amazon.com: 99BVJEHJ6TFXHJ43, S3.GET.OBJECT","s3-prod-s3ws-nlb-iad7-u99-p1-7018.iad7.amazon.com: 99BQJ9S6X4HQ75V5, S3.PUT.OBJECT","s3-prod-s3ws-nlb-iad7-u99-p1-7010.iad7.amazon.com: QYG5A7T2HJGRJDDQ, S3.PUT.OBJECT","s3-prod-s3ws-nlb-iad7-u99-p1-7010.iad7.amazon.com: QYG4R8HBRN6XCZVK, S3.GET.OBJECT","s3-prod-s3ws-nlb-iad7-u99-p1-7022.iad7.amazon.com: G8FPTV6CT60FP0GF, S3.PUT.OBJECT","s3-prod-s3ws-nlb-iad7-u99-p1-7022.iad7.amazon.com: H5DD9JQ233VCEMC8, S3.GET.OBJECT","s3-prod-s3ws-nlb-iad7-u99-p1-7027.iad7.amazon.com: H5DD4N501VQ234WM, S3.GET.OBJECT","s3-prod-s3ws-nlb-iad7-u99-p1-7027.iad7.amazon.com: H5D86ZDYABRY7DNE, S3.PUT.OBJECT","s3-prod-s3ws-nlb-iad7-u99-p1-7015.iad7.amazon.com: 4HJ331Z7ZCRP0EMQ, S3.PUT.OBJECT","s3-prod-s3ws-nlb-iad7-u99-p1-7015.iad7.amazon.com: 4HJ6726WAJA8S5AM, S3.GET.OBJECT","s3-prod-s3ws-nlb-iad7-u99-p1-7008.iad7.amazon.com: G8FRTDZDZGTWBJVZ, S3.PUT.OBJECT","s3-prod-s3ws-nlb-iad7-u99-p1-7008.iad7.amazon.com: G8FZ96BZ9K4JEWHE, S3.GET.OBJECT","s3-prod-s3ws-nlb-iad7-u99-p1-7016.iad7.amazon.com: AZP7GG85JN3ET1YF, S3.PUT.OBJECT","s3-prod-s3ws-nlb-iad7-u99-p1-7016.iad7.amazon.com: AZP8WRXD7609T591, S3.GET.OBJECT","s3-prod-s3ws-nlb-iad7-u99-p1-7036.iad7.amazon.com: DCQJ1MX87J0021ED, S3.GET.OBJECT","s3-prod-s3ws-nlb-iad7-u99-p1-7036.iad7.amazon.com: DCQQ6X02BGBCJXST, S3.PUT.OBJECT","s3-prod-s3ws-nlb-iad7-u99-p1-7039.iad7.amazon.com: K906M0KY54XAN223, S3.GET.OBJECT","s3-prod-s3ws-nlb-iad7-u99-p1-7039.iad7.amazon.com: K90DRR02301MQ63W, S3.PUT.OBJECT","s3-prod-s3ws-nlb-iad7-u99-p1-7025.iad7.amazon.com: 163XJEHQ2AKKMVF4, S3.GET.OBJECT","s3-prod-s3ws-nlb-iad7-u99-p1-7025.iad7.amazon.com: 163TP4RZSGRVX5QT, S3.PUT.OBJECT","s3-prod-s3ws-nlb-iad7-u99-p1-7007.iad7.amazon.com: 163QC3903SES80HJ, S3.GET.OBJECT","s3-prod-s3ws-nlb-iad7-u99-p1-7007.iad7.amazon.com: 163S59776XAJEH8P, S3.PUT.OBJECT","s3-prod-s3ws-nlb-iad7-u99-p1-7038.iad7.amazon.com: XKBFP7VNENE6Z70C, S3.GET.OBJECT","s3-prod-s3ws-nlb-iad7-u99-p1-7038.iad7.amazon.com: XKB3HNATCSAV50JF, S3.PUT.OBJECT","s3-prod-s3ws-nlb-iad7-u99-p1-7021.iad7.amazon.com: NG3X611HH23ENRR7, S3.PUT.OBJECT","s3-prod-s3ws-nlb-iad7-u99-p1-7021.iad7.amazon.com: NG3JMQT2JVAYD805, S3.GET.OBJECT","s3-prod-s3ws-nlb-iad7-u99-p1-7014.iad7.amazon.com: WWAJ3NNM5K231FWX, S3.PUT.OBJECT","s3-prod-s3ws-nlb-iad7-u99-p1-7014.iad7.amazon.com: WWAR55DWBNK65R7G, S3.GET.OBJECT","s3-prod-s3ws-nlb-iad7-u99-p1-7005.iad7.amazon.com: 5H653HN59B6R77HR, S3.PUT.OBJECT","s3-prod-s3ws-nlb-iad7-u99-p1-7005.iad7.amazon.com: 5H607NPXAAPJS32G, S3.GET.OBJECT","s3-prod-s3ws-nlb-iad7-u99-p1-7040.iad7.amazon.com: DCQK3J2P48J4DXN1, S3.PUT.OBJECT","s3-prod-s3ws-nlb-iad7-u99-p1-7040.iad7.amazon.com: DCQZT3HP0ADENZA2, S3.GET.OBJECT","s3-prod-s3ws-nlb-iad7-u99-p1-7033.iad7.amazon.com: DCQKJQQPPBJ9JQAQ, S3.GET.OBJECT","s3-prod-s3ws-nlb-iad7-u99-p1-7033.iad7.amazon.com: DCQT9KJPQ05HFX1W, S3.PUT.OBJECT","s3-prod-s3ws-nlb-iad7-u99-p1-7012.iad7.amazon.com: WWAR7TDTYFS5N92C, S3.GET.OBJECT","s3-prod-s3ws-nlb-iad7-u99-p1-7012.iad7.amazon.com: WWARQVV2RS638NYF, S3.PUT.OBJECT","s3-prod-s3ws-nlb-iad7-u99-p1-7037.iad7.amazon.com: 6MRW7YNJC7ZTHN5P, S3.GET.OBJECT","s3-prod-s3ws-nlb-iad7-u99-p1-7037.iad7.amazon.com: 6Y0N3MNDXC3V0D00, S3.PUT.OBJECT","s3-prod-s3ws-nlb-iad7-u99-p1-7019.iad7.amazon.com: NG3T6B099XTAB45P, S3.GET.OBJECT","s3-prod-s3ws-nlb-iad7-u99-p1-7019.iad7.amazon.com: NG3GJHEASX71S2JM, S3.PUT.OBJECT","s3-prod-s3ws-nlb-iad7-u99-p1-7002.iad7.amazon.com: NG3HF7AE5JXCCD0H, S3.PUT.OBJECT","s3-prod-s3ws-nlb-iad7-u99-p1-7002.iad7.amazon.com: NG3HC20ER72Z1AMZ, S3.GET.OBJECT"
        );

        Map<String, List<String >> result = hostsByOperation(data);

        for(String key : result.keySet()) {
            System.out.println(key + " = " + result.get(key));
            System.out.println();
        }

        hostCount.forEach((k, v) -> {
            System.out.println("Host -> " + k + " Count -> "+ v);
        });

        System.out.println(hostCount.keySet().size());
    }
}
