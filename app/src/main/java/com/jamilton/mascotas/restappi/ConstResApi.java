package com.jamilton.mascotas.restappi;

public final class ConstResApi {

    public static final String ROOT_URL= "https://graph.instagram.com/";

    public static final String ACCES_TOKEN = "IGQVJYU1VDMDNKR0dIdlR1RV9NRGp6c2RsVzhhV1NJRXZACNGM2SUMxLW9nRU5nOU5SSXZAOeWdZAUEtLRlpzemZAZAVFh4UFZAvYzl6emwwYzh5YzlYY3BzTXAzSl9HbE5iVTd6UVZAobEV3";

    public static final String KEY_ACCES_TOKEN = "&access_token=";

    public static final String KEY_GET_INFORMATION_USER = "me/media?fields=id,media_url,caption,timestamp,media_type,permalink,thumbnail_url,username";

    public static final String KEY_GET_INFOR_ID = "me?fields=ig_id";//account_type,id,ig_id,media_count,username

    public static final String URL_GET_INFORMATION_USER = KEY_GET_INFORMATION_USER + KEY_ACCES_TOKEN + ACCES_TOKEN;

    public static final String URL_GET_ID_INSTAGRAM = KEY_GET_INFOR_ID + KEY_ACCES_TOKEN + ACCES_TOKEN;

    public static final String ROOT_URLM   = "https://morning-cove-80794.herokuapp.com/";

    public static final String KEY_POST_ID = "registrar-usuario/";
}
