package com.aini.express.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.ObjectUtils;

public class CommonUtil {
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Map getMap(HttpServletRequest req) {
        Map rmap = new HashMap();
        Enumeration en = req.getParameterNames();
        while (en.hasMoreElements()) {
            String paramName = en.nextElement().toString();
            rmap.put(paramName, req.getParameter(paramName));
        }
        return rmap;
    }
	
	@SuppressWarnings("rawtypes")
	public static String getJson(List src, String[] columnName) {
        if (CollectionUtils.isEmpty(src)) {
            return "[]";
        }
        StringBuilder buf = new StringBuilder("[");
        for (int i = 0; i < src.size(); i++) {
            Object ele = src.get(i);
            buf.append(i == 0 ? "" : ",");
            try {
                buf.append(parseJson(ele, columnName));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        buf.append("]");
        return buf.toString();
    }

    @SuppressWarnings("rawtypes")
	public static String getJson(List src) {
        if (CollectionUtils.isEmpty(src)) {
            return "[]";
        }
        StringBuilder buf = new StringBuilder("[");
        for (int i = 0; i < src.size(); i++) {
            Object ele = src.get(i);
            buf.append(i == 0 ? "" : ",");
            try {
                buf.append(parseJson(ele, null));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        buf.append("]");
        return buf.toString();
    }

    @SuppressWarnings("rawtypes")
	public static String getJson(Map map, String[] columnName) {
        if (MapUtils.isEmpty(map)) {
            return "";
        }
        StringBuilder buf = new StringBuilder("");
        try {
            buf.append(parseJson(map, columnName));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return buf.toString();
    }

    @SuppressWarnings("rawtypes")
	public static String getJson(Map map) {
        if (MapUtils.isEmpty(map)) {
            return "";
        }
        StringBuilder buf = new StringBuilder("");
        try {
            buf.append(parseJson(map, null));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return buf.toString();
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	private static String parseJson(Object obj, String[] columnName) throws Exception {
        int s = 0;
        if (ObjectUtils.isEmpty(obj)) {
            return "";
        }
        if ((obj instanceof Map)) {
            Map map = (Map) obj;
            StringBuilder buf = new StringBuilder("{");
            Iterator<String> iter = map.keySet().iterator();
            for (; iter.hasNext(); ) {
                String key = (String) iter.next();
                if (columnName == null) {
                    buf.append(s == 0 ? "" : ",");
                    buf.append("\"").append(key).append("\":\"");
                    buf.append(
                        map.get(key) != null
                            ? map.get(key).toString().replace("'", "'").replace("\r\n", "\\r\\n").replace("\"", "\\\"")
                            .replace("\r", "\\r").replace("\t", "\\t").replace("\n", "\\n")
                            : "").append("\"");
                    s++;
                } else {
                    for (int i = 0; i < columnName.length; i++) {
                        if (key.equals(columnName[i])) {
                            buf.append(s == 0 ? "" : ",");
                            buf.append("\"").append(key).append("\":\"");
                            buf.append(
                                    map.get(key) != null
                                            ? map.get(key).toString().replace("'", "'").replace("\r\n", "\\r\\n")
                                            .replace("\"", "\\\"").replace("\r", "\\r").replace("\t", "\\t")
                                            .replace("\n", "\\n")
                                            : "")
                                    .append("\"");
                            s++;
                        }
                    }
                }
            }
            buf.append("}");
            return buf.toString();
        }
        if ((obj instanceof List)) {
            return getJson((List) obj, columnName);
        }
        throw new Exception();
    }
    
    /**
     * 리턴페이지 호출
     * @param request
     * @return
     */
    public static String page(HttpServletRequest request) {
        return StringUtils.replace(request.getRequestURI(), ".do", "");
    }
    
    
    /**
	 * 휴대전화번호 유혀성 검사 
	 * @param hpNo
	 * @return
	 */
	public static boolean checkHpNo(String hpNo){
		hpNo = hpNo.replaceAll("[^0-9]", "");
		String regExp = "^01([0|1|6|7|8|9]?)-?([0-9]{3,4})-?([0-9]{4})$";
		return hpNo.matches(regExp);
	}
	
	/**
	 * 이메일주소 유효성 검사
	 * @param email
	 * @return
	 */
	public static boolean checkEmail(String email){
		String regExp = "[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+";
		Pattern p = Pattern.compile(regExp);
		Matcher m = p.matcher(email);
		return m.matches();
	}
	
	/**
	 * 비밀번호 유효성 검사
	 * @param pw
	 * @param id
	 * @return
	 */
	public static Map<String , Object> checkPswd(String pw, String id){
		Map<String , Object> retMap = new HashMap<String , Object>();
		String reg = "^(?=.*?[a-zA-Z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{10,}$";
		
		if (false == pw.matches(reg)){
			retMap.put("result", "false");
			retMap.put("message", "비밀번호는 숫자/영문/특수문자를 모두 포함하여 10자 이상으로 생성해야합니다.");
		} else if (sameStr(pw)){
			retMap.put("result", "false");
			retMap.put("message", "비밀번호에 같은문자가 4번연속 포함되어 있습니다.");
		} else if(StringUtils.contains(pw, id)){
			retMap.put("result", "false");
			retMap.put("message", "비밀번호에 아이디가 포함되어 있습니다.");
		} else if(StringUtils.contains(pw, " ")){
			retMap.put("result", "false");
			retMap.put("message", "비빌번호에 공백이 포함되어 있습니다.");
		} else if (str4Check(pw)){
			retMap.put("result", "false");
			retMap.put("message", "비밀번호에 4자리 연속된 문자가 포함되어 있습니다.");
		} else {
			retMap.put("result", "true");
		}
		return retMap;
	}
	
	/**
	 * 비밀번호 유효성 검사 중 같은분자 반복여부 체크
	 * @param pw
	 * @return
	 */
	public static boolean sameStr(String pw){
		String serial = "(\\w)\\1\\1\\1";
		return Pattern.compile(serial).matcher(pw).find() ? true:false;
		
	}
	
	/**
	 * 비밀번호 유효성 검사 중 4번 반복 
	 * @param pw
	 * @return
	 */
	public static boolean str4Check(String pw){
		int o = 0;
		int d = 0;
		int p = 0;
		int n = 0;
		int limit = 4;
		for (int i=0;i<StringUtils.length(pw);i++){
			char tempVal = pw.charAt(i);
			if (i>0 &&(p=o-tempVal) > -2 && (n=p==d?n+1:0)>limit-3){
				return true;
			}
			d = p;
			o = tempVal;
		}	
		return false;
	}
	
	/**
	 * 아이디 유효성 검사
	 * @param userID
	 * @return
	 */
	public static boolean checkUserId(String userID){
		String regExp = "^[a-zA-Z]{1}[a-zA-Z0-9_]{4,15}$";
		Matcher matcher = Pattern.compile(regExp).matcher(userID);
		return matcher.matches();
	}
	
	
	/**
	 * 임시비밀번호 발급
	 * @return
	 */
	public static String createNewPassword() {
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        sb.append(charArr[random.nextInt(26)])
                .append(getRandomValue(random))
                .append(getRandomValue(random))
                .append(getRandomValue(random))
                .append(getRandomValue(random))
                .append(getRandomValue(random))
                .append(getRandomValue(random))
                .append(getRandomValue(random));
        return sb.toString();
    }
	
	
	/**
	 * 랜덤난수 발생
	 * @param random
	 * @return
	 */
	private static String getRandomValue(Random random) {
        String result = "";
        int type = random.nextInt(2);

        if (type == 0) {
            result = charArr[random.nextInt(26)] + "";
        } else {
            result = random.nextInt(10) + "";
        }
        return result.toUpperCase();
    }
	
	private static char[] charArr = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    
	
	@SuppressWarnings("deprecation")
	public static String ConvertTagHTML(String str) {
		str = StringUtils.replaceAll(str, "&lt;", "<");
		str = StringUtils.replaceAll(str, "&gt;", ">");
		str = StringUtils.replaceAll(str, "&quot;", "\"");
		str = StringUtils.replaceAll(str, "&#39;", "'");
		str = StringUtils.replaceAll(str, "&amp;", "&");
		str = StringUtils.replaceAll(str, "&ldquo;", "\"");
		str = StringUtils.replaceAll(str, "&rdquo;", "\"");
		str = StringUtils.replaceAll(str, "&lsquo;", "\'");
		str = StringUtils.replaceAll(str, "&rsquo;", "\'");
		str = StringUtils.replaceAll(str, "&middot;", "·");
		str = StringUtils.replaceAll(str, "&hellip;", "...");
		str = StringUtils.replaceAll(str, "\n", "<br>");
		return str;
	}
	
	@SuppressWarnings("deprecation")
	public static String ConvertTagHTML2(String str) {
		str = StringUtils.replaceAll(str, "&lt;", "<");
		str = StringUtils.replaceAll(str, "&gt;", ">");
		str = StringUtils.replaceAll(str, "&quot;", "\"");
		str = StringUtils.replaceAll(str, "&#39;", "'");
		str = StringUtils.replaceAll(str, "&amp;", "&");
		str = StringUtils.replaceAll(str, "&ldquo;", "\"");
		str = StringUtils.replaceAll(str, "&rdquo;", "\"");
		str = StringUtils.replaceAll(str, "&lsquo;", "\'");
		str = StringUtils.replaceAll(str, "&rsquo;", "\'");
		str = StringUtils.replaceAll(str, "&middot;", "·");
		str = StringUtils.replaceAll(str, "&hellip;", "...");
		return str;
	}
	
	@SuppressWarnings("deprecation")
	public static String ConvertTagHTML3(String str) {
		str = StringUtils.replaceAll(str, "\n", "<br>");
		return str;
	}
	
	
	/**
     * 전달된 파라미터에 맞게 난수를 생성한다
     * @param len : 생성할 난수의 길이
     * @param dupCd : 중복 허용 여부 (1: 중복허용, 2:중복제거)
     */
    public static String numberGen(int len, int dupCd ) {
        
        Random rand = new Random();
        String numStr = ""; //난수가 저장될 변수
        
        for(int i=0;i<len;i++) {
            
            //0~9 까지 난수 생성
            String ran = Integer.toString(rand.nextInt(10));
            
            if(dupCd==1) {
                //중복 허용시 numStr에 append
                numStr += ran;
            }else if(dupCd==2) {
                //중복을 허용하지 않을시 중복된 값이 있는지 검사한다
                if(!numStr.contains(ran)) {
                    //중복된 값이 없으면 numStr에 append
                    numStr += ran;
                }else {
                    //생성된 난수가 중복되면 루틴을 다시 실행한다
                    i-=1;
                }
            }
        }
        return numStr;
    }
    
    /**
     * 파일해시값 가져오기
     * @param path : 파일
     */
    public static String getHash(String path) throws IOException, NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        FileInputStream fileInputStream = new FileInputStream(path);
        byte[] dataBytes = new byte[1024];
        Integer nRead = 0;
        while((nRead = fileInputStream.read(dataBytes)) != -1) {
            messageDigest.update(dataBytes, 0, nRead);
        }
        byte[] mdBytes = messageDigest.digest();
        StringBuffer stringBuffer = new StringBuffer();
        for(Integer i = 0; i < mdBytes.length; i++) {
            stringBuffer.append(Integer.toString((mdBytes[i] & 0xff) + 0x100, 16)).substring(1);
        }
        return stringBuffer.toString();
    }

}
