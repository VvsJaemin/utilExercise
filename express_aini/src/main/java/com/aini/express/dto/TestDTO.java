package com.aini.express.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter 
@ToString
public class TestDTO extends BaseDTO {
    private static final long serialVersionUID = 1L;
    
    private String no;
    private String exp_not_region;
    private String exp_set_region;
    private String exp_add_price_region;
    private String set_cost;
    private String set_item_cate;
    private String order_list_num;
    private String exp_order_list_num;
    private String claim_order_list_num;
    private String account_list_num;
    private String exp_noship_order_list_num;
    private String put_order_list_num;
    private String rs_order_insert_list_num;
    private String nomatch_colors;
    private String order_filter_filed;
    private String order_filter_key;
    private String order_claim_status;
    private String order_claim_last_id;
    private String sms_use;
    private String sms_type;
    private String sms_icode_id;
    private String sms_icode_pw;
    private String sms_icode_server_ip;
    private String sms_icode_server_port;
    private String sms_default_phone;
    private String xls_limit;
    
}
