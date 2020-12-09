package example.pc.vo;

import example.pc.Enum.ResultEnum;

public class Result {
    private static ResultEnum resultCode;
    private static Object resultData;
//    private static Result result = null;
//
////    private Result instance(){
////        synchronized (result){
////            if (result == null){
////                Result result = new Result();
////            }
////        }
////        return result;
////    }

    public static ResultEnum getResultCode() {
        return resultCode;
    }


    public static Result setResultCode(ResultEnum resultCode) {
        Result.resultCode = resultCode;
        return null;
    }

    public static Object getResultData() {
        return resultData;
    }


    public static Result setResultData(Object resultData) {
        Result.resultData = resultData;
        return null;
    }
}
