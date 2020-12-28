package com.crown.easypoi;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;

/**
 * @ClassName BaseTest
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2020-10-29
 * @Time 17:22
 * @Version 1.0
 */
public class BaseTest {
    public static void main(String[] args) {
        // 测试从Base64编码转换为图片文件
        String strImge = "data:image/png;base64,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GKjhprMIIIAAAggggIC5AEHR3IqSCCCAAAIIIIBAoAQIioEabjqLAAIIIIAAAgiYCxAUza0oiQACCCCAAAIIBEqAoBio4aazCCCAAAIIIICAuQBB0dyKkggggAACCCCAQKAECIqBGm46iwACCCCAAAIImAsQFM2tKIkAAggggAACCARKgKAYqOGmswgggAACCCCAgLkAQdHcipIIIIAAAggggECgBAiKgRpuOosAAggggAACCJgLEBTNrSiJAAIIIIAAAggESoCgGKjhprMIIIAAAggggIC5AEHR3IqSCCCAAAIIIIBAoAQIioEabjqLAAIIIIAAAgiYCxAUza0oiQACCCCAAAIIBEqAoBio4aazCCCAAAIIIICAuQBB0dyKkggggAACCCCAQKAECIqBGm46iwACCCCAAAIImAsQFM2tKIkAAggggAACCARKgKAYqOGmswgggAACCCCAgLkAQdHcipIIIIAAAggggECgBAiKgRpuOosAAggggAACCJgLEBTNrSiJAAIIIIAAAggESoCgGKjhprMIIIAAAggggIC5AEHR3IqSCCCAAAIIIIBAoAQIioEabjqLAAIIIIAAAgiYCxAUza0oiQACCCCAAAIIBEqAoBio4aazCCCAAAIIIICAuQBB0dyKkggggAACCCCAQKAECIqBGm46iwACCCCAAAIImAsQFM2tKIkAAggggAACCARKgKAYqOGmswgggAACCCCAgLkAQdHcipIIIIAAAggggECgBAiKgRpuOosAAggggAACCJgLEBTNrSiJAAIIIIAAAggESoCgGKjhprMIIIAAAggggIC5AEHR3IqSCCCAAAIIIIBAoAQIioEabjqLAAIIIIAAAgiYCxAUza0oiYBnBTo7OyUUCkl6erpn+0DDEUAAAQRGX4CgOPrmXHEUBPa2d8h91dXyUn297GhrH4Urxn6JaTnZcnpxsVw8caJMyc6KvQLDM/785z/Lz3/+c/nud78rp59+uuFZyS3W2tQtuzY1Su3+Vmlp6EruxeKsPa8oU8ZPypXKWYWSWxCKs5bBpy1ZskQefvhh+fSnPy3Tpk1zpM5kVFLT0itP7uyQVdVdsr+5NxmXSLjOSfnpsnBippxTlSUT8pL3F6D6+nq56qqrrPb+9Kc/leLi4oTbTgUIeEmAoOil0aKtRgIP1NTKjdt3GJV1S6Hrp0+TD04Yn5Tm7NixQz7/+c9LZWWlFRYLCwuTch3TSvdsaZK1y+pMi7ui3PxTx0nFjIKE2qKzut/73vfkjTfekJ/97GcyZcqUgfr6+vqkublZenp6rF/Tf96/f7/oOZs3b5aWlhZZt26d1NXVydvf/nZrPDMyMhJqz1AnP7OrU+5a1ZqUupNV6ScX5sq7KsckpXqCYlJYqdRDAgRFDw0WTR1ZwIsh0e5VrGHxqaeekrvvvntEFA0he/fuldbWVqmqqpKsrJFnLy+55BJ597vfPWLdsRbwYki0+5hoWNQx0ID3jne8w/r50UcflRtvvDEmQh2/GTNmyJe//GUpKSmJ6VyTwl4MiXa/khUWCYomdw5l/CxAUPTz6Aasb/q4+f1vrPJ0rx9dtND4MbRpUIwHJBlBUR83P//wnnia45pzzrygIu7H0Pfff7/ceuut1msAxx13nDzyyCNWUDzvvPOkoqJCZs6cKWPGjLFmD++8806ZOnWqfOlLX5Lc3FzJz8+XtLS0pDro4+YvPt2Y1Gsku/KfnF3o+GNogmKyR4363S5AUHT7CNE+Y4Ef7totdx84aFzejQUvKS+T/6mc6samJdymDSsOy84NDQnXk8oKquYUyZwTx8bchNraWiv0lZWVyQ033GCFPzso/vKXv5Tjjz9+oM729nb59re/bf37ddddJ9nZ2TFfL54T7lnXJo9t64jnVNecc+4xWfLxeTmOtoeg6CgnlXlQgKDowUGjydEFLli12rULV0zHTBe4PLzwONPig8olMsN49tlnyyc+8Ym4rmt60guP7HXtwhXTPugClzPOf+vdQtPzNBTq+6EaAO1H+iMFxSNHjljvNBYUJPZupGkbr3mm0bULV0z7oAtcfvAu83dwGxsbLeN9+/YNeYnu7m7R93z10AVIunvAUIe+/6uvBegMMQcCfhEgKPplJOmHLFz2ii8UVp16clz9sIOHvseWl5dnVEdHR4fs3LlTPvaxj8mVV15pdE68hR6721sLjIbq57mXxLZa+dChQ/K1r33NWnzy/e9/f2Ax0UhBUd9pHM1Vth97pD7eoXXVeX8433xVsj1buHv3bmtxUbTH+yZB0X4PWP/c6UIlN69od9Vg0RhPCBAUPTFMNNJEgKDY/85b5KPM4ezsFdHnnHMOQdHkJhORWIKiBgjdnugHP/iBvO997xv0KHmooKjnaNhYuXIlQdFwTMKLxRMUNSQO9Zjf5NGz/brAqlWrCIpxjBmnuFuAoOju8aF1MQgQFPuD4o9//GNrsYTJoTMpOtulIYYZRROx2IKiztZeffXVos6mQVFboYteXnvtNYKi2ZAMKkVQjAONUxAYRoCgyO3hGwGCYn9QjOe49NJLCYqGcKYzijrLpI+aH3vsMeu9tne+851RZxSjvSpw8OBBaWhoGHI7o2SsSg/yo2dmFA1vfooFUoCgGMhh92enCYrMKI7GnW0SFPXx8d/+9jdrAcvFF18sGvw0LIY/3rQfPcfT5uuvv17OP//8eE4d8hyCYvQV5jx6dvQ2ozIPChAUPThoNDm6QNCDotvviyAtZtEvrOh7htu2bRMNdfrPekQLitHeKbVXSd9xxx2yaNGiURlagiJBcVRuNC7iOQGCoueGjAYPJRDEoGgvRjlw4IBjN0Ysi2FiuWiQgqK6rF692tooe9KkSVH3RRxqMYue+9JLL1nfF7799tvl5JPjWwUfy9ho2SAHxQkTJlj7XEb7apFuoXPttddanN/5zneifgJTdw/40Y9+JBs2bGAxS6w3HuVdL0BQdP0Q0UBTgSAHxQULFsgFF1xgShW13NKlS61PAhIUh2c0efQcXsNQG2gPFxTXrl0rn/nMZ+SLX/yiXHjhhQmNq+nJQQ6K6u3EUV5eTlB0ApI6XCVAUHTVcNCYRASCHBSd2N5muOCSyLjY5wZtRtHudzxBcf/+/fKFL3xBTj/9dOu70Mn+fF/QZxT1O+hnnnlm1M20dfwef/xxazh15Xq0L+XoXovPP/+8tLW1ERSd+I8FdbhKgKDoquGgMYkIEBT7N8yO5XF0+OwhQdHs7huNGUUNLt/4xjesBn3rW9+yPvmX7COIM4r2l1nGjRsnn/vc56xvbUceJotZOjs7rW946589vsyS7DuV+kdbgKA42uJcL2kCBMXBQVE/FXfaaadF9d66dau13yJBMfbbMdlBsaury5rZ0vcTdSYr/EsfukhGQ6S+++j0LGMQg6LJ6JsERZN6KIOAVwUIil4dOdp9lABBcXBQ/NSnPjXkFiqvv/66XHHFFQTFOP4cJSso6mPLe++9V/TTfV/96lfFfk9RF1l8+MMftlpqzzTqDJj+erQZsDi6ZJ1CUIwuR1CM947iPL8IEBT9MpL0I5Dfeo72CT7712bMmCGzZs2Kemfovn66zx8zirH/wXE6KOpXWOrq6kS3wqmurpZzzz3X+lqOvvf2la98xWqg/Y1oO7QsXrzY8XcXCYoExdj/NHBGEAQIikEY5YD0kRnFwTOK+miypKRk2NG/5pprZP78+VYZ3lE0+4PiVFB86KGHrO1W9P1DnSmsqKiwtsSZPn266JdCdPzsMdHZ4csvv1z27dtnBcSPfOQj8tGPftSswYalCIoERcNbhWIBEyAoBmzA/dxdgqL5o+fI+0DffdMZLd0eJ1mbPLPq+a0Ntw8fPmztzffqq69aj481BGrwe/LJJ+Wmm26Sr3/963LeeedJS0uL3HDDDda+ipdddpmUlpbKD3/4Qytgnn322Y7+cSYoEhQdvaGozDcCBEXfDCUdISj2B0WTo6amxpq92rx586Dic+fOtTYOHj9+vEk1MZUhKL4VFO1gru8h6mPmqVOnWpY6s6iPmZ944omBsKibqesK6FWrVlllkrVXH0GRoBjTH2gKB0aAoBiYofZ/Ry9YtVp2tLV7uqPTcrLl4YXHGfch2juKJifr3nC6nceaNWsGih9zzDHyiU98QqqqqkyqiLnMC4/slZaGrpjPc9MJeUWZcsb5U2Jq0lD7KOrilfT09KO+BqJh8eabb5Z58+bJRRddJBkZGdb+fPpO6YoVK+RDH/qQnHTSSY6ver7mmUbZ39wbU9/cVnhSfrr84F2FjjaLxSyOclKZBwUIih4cNJocXeCHu3bL3QcOeprnkvIy+Z/K/tklvx0bVhyWnRsaPN2tqjlFMufEsTH1oa+vT5qbm61zTLe16e3ttYKg01vgDNfwe9a1yWPbOmLqm9sKn3tMlnx8Xo6jzdKxCB8/DfccCARJgKAYpNH2eV/3tnfI+9/ofzzn1ePRRQtlSnaWV5s/bLtbm7rl+Yf3eLpvZ15QIbkFIU/3YajG17T0yhefbvR0335ydqFMyCPIeXoQabzrBAiKrhsSGpSIwAM1tXLj9h2JVJGyc6+fPk0+OMH5dwNT1qEoF96zpUnWLqtzU5OM2zL/1HFSMaPAuLwXCz6zq1PuWtXqxabLJxfmyrsqj/6yiic7Q6MRcJEAQdFFg0FTnBHwYlgMQki0R9eLYTEIIdEeHy+GRUKiM//tpBYEogkQFLkvfCmgj6Hvq66Wl+rrXbvARReunF5cLBdPnOjbx81D3Vz6GHrXpkap3d/q2gUuunBl/KRcqZxV6NvHzUONjz6GfnJnh6yq7nLtApdJ+RmycGJIzqnK4nGzL/8rTqfcIkBQdMtI0A4EEEAAAQQQQMBlAgRFlw0IzUEAAQQQQAABBNwiQFB0y0jQDgQQQAABBBBAwGUCBEWXDQjNQQABBBBAAAEE3CJAUHTLSNAOBBBAAAEEEEDAZQIERZcNCM1BAAEEEEAAAQTcIkBQdMtI0A4EEEAAAQQQQMBlAgRFlw0IzUEAAQQQQAABBNwiQFB0y0jQDgQQQAABBBBAwGUCBEWXDQjNQQABBBBAAAEE3CLw/42eoy47KSt/AAAAAElFTkSuQmCC";
        String[] split = strImge.split(",");
        System.out.println(split[1]);
        System.out.println("======");
        String suffix = split[0].split(";")[0].split("/")[1];
        System.out.println(suffix);
        GenerateImage(split[1], "D:\\"+11+"."+suffix);
        // 测试从图片文件转换为Base64编码
        // System.out.println(GetImageStr("d:\\11.jpg"));
    }
    public static String GetImageStr(String imgFilePath) {// 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
        byte[] data = null;

        // 读取图片字节数组
        try {
            InputStream in = new FileInputStream(imgFilePath);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);// 返回Base64编码过的字节数组字符串
    }

    public static boolean GenerateImage(String imgStr, String imgFilePath) {// 对字节数组字符串进行Base64解码并生成图片
        if (imgStr == null) // 图像数据为空
            return false;
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            // Base64解码
            byte[] bytes = decoder.decodeBuffer(imgStr);
            for (int i = 0; i < bytes.length; ++i) {
                if (bytes[i] < 0) {// 调整异常数据
                    bytes[i] += 256;
                }
            }
            // 生成jpeg图片
            OutputStream out = new FileOutputStream(imgFilePath);
            out.write(bytes);
            out.flush();
            out.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}