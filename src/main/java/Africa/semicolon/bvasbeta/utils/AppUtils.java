package Africa.semicolon.bvasbeta.utils;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class AppUtils {
    private static int currentId;
    public static final int ZERO = 0;
    public static final int EIGHT = BigInteger.valueOf(8).intValue();
    public static final int ONE = BigInteger.valueOf(1).intValue();
    public static final int TWO = BigInteger.valueOf(2).intValue();

    public static final int FIVE = BigInteger.valueOf(5).intValue();
    private static Map<String, String > userInformationJoinTable =new HashMap<>();

    public static String generatedId(){
        currentId+=1;
        int generatedId = currentId;
        return String.valueOf(generatedId);
    }
    public static void linkUserToUseInformation(String userId,String userInformationId){
        userInformationJoinTable.put(userId,userInformationId);
    }
    public static String getUserInformationId(String userId){
        String userInformationId = userInformationJoinTable.get(userId);
        return userInformationId;
    }
}
