//package com.ax.shop.util.axtools;
//
//import com.alibaba.fastjson.JSONException;
//import com.alibaba.fastjson.parser.DefaultJSONParser;
//import com.alibaba.fastjson.parser.JSONLexer;
//import com.alibaba.fastjson.parser.JSONToken;
//import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
//
//
//import java.lang.reflect.Type;
//
//public class FastJsonEnumDeserializer implements ObjectDeserializer {
//
//    @Override
//    public <T> T deserialze(DefaultJSONParser parser, Type type, Object o) {
//        final JSONLexer lexer = parser.lexer;
//        final int token = lexer.token();
//        Class cls = (Class) type;
//        Object[] enumConstants = cls.getEnumConstants();
//        if (AxResultStatusEnum.class.isAssignableFrom(cls)) {
//            for (Object enumConstant : enumConstants) {
//                BaseEnum<Integer> baseEnum = (BaseEnum<Integer>) enumConstant;
//                Object enumCodeObject = baseEnum.getCode();
//                int enumCode = Integer.parseInt(enumCodeObject.toString());
//                if (lexer.intValue() == enumCode) {
//                    return (T) baseEnum;
//                }
//            }
//        } else {
//            //没实现EnumValue接口的 默认的按名字或者按ordinal
//            if (token == JSONToken.LITERAL_INT) {
//                int intValue = lexer.intValue();
//                lexer.nextToken(JSONToken.COMMA);
//                if (intValue < 0 || intValue > enumConstants.length) {
//                    throw new JSONException(String.format("parse enum %s error, value : %s", cls.getName(), intValue));
//                }
//                return (T) enumConstants[intValue];
//            } else if (token == JSONToken.LITERAL_STRING) {
//                return (T) Enum.valueOf(cls, lexer.stringVal());
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public int getFastMatchToken() {
//        return JSONToken.LITERAL_INT;
//    }
//
//}