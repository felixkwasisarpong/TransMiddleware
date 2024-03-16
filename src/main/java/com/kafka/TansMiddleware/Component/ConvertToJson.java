package com.kafka.TansMiddleware.Component;
import org.bitbucket.openisoj2.postilion.Iso8583Postilion;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class ConvertToJson {


    public static String isoToJson(byte[] buffer) throws Exception {
        Iso8583Postilion msg_from_remote = new Iso8583Postilion();
        msg_from_remote.unpack(buffer, 0);
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("MTI", msg_from_remote.getMsgType());
        // Add data to the JSON object
        jsonObject.put("proCode", msg_from_remote.getFieldValue(3));
        jsonObject.put("amount", msg_from_remote.getFieldValue(4));
        jsonObject.put("Transmission_dtime", msg_from_remote.getFieldValue(7));
        jsonObject.put("Trace_number", msg_from_remote.getFieldValue(11));
        jsonObject.put("time_local", msg_from_remote.getFieldValue(12));
        jsonObject.put("date_local", msg_from_remote.getFieldValue(13));
        jsonObject.put("pos_code", msg_from_remote.getFieldValue(22));
        jsonObject.put("acq_inst_id", msg_from_remote.getFieldValue(32));
        jsonObject.put("ret_ref_num", msg_from_remote.getFieldValue(37));
        jsonObject.put("card_acc_term_id", msg_from_remote.getFieldValue(41));
        jsonObject.put("card_acc_id", msg_from_remote.getFieldValue(42));
        jsonObject.put("merch_name", msg_from_remote.getFieldValue(43));
        jsonObject.put("currency", msg_from_remote.getFieldValue(49));


        // Convert JSON object to string
        String jsonString = jsonObject.toString();

        return jsonString;
    }
}
