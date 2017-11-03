package com.kco.jsoup.demo1;

/**
 * Created by 666666 on 2017/11/3.
 */
public class Const {
    public static final String[] BOOK_URL ={
         // 征服女领导：升迁暗影
        "http://transcoder.baiducontent.com/tc?srd=1&dict=32&h5ad=1&bdenc=1&lid=8874999729740906145&title=&nsrc=IlPT2AEptyoA_yixCFOxXnANedT62v3IEQGG_ztQ0Su9pEK7hO4nFRhpUDSqAp7VFkT8x7a4fsgYwk0yQTJzoLt2qKtjqnN8nyC-",
            "http://transcoder.baiducontent.com/tc?srd=1&dict=32&h5ad=1&bdenc=1&lid=8874999729740906145&title=&nsrc=IlPT2AEptyoA_yixCFOxXnANedT62v3IEQGG_ztQ0Su9pEK7hO4nFRhpUDSqAp7XZpPPwHOReMYYwk_d07UlzBAxr_xms89hbSS8w_m58BO_HBAOcNkk2dq",
            "http://transcoder.baiducontent.com/tc?srd=1&dict=32&h5ad=1&bdenc=1&lid=8874999729740906145&title=&nsrc=IlPT2AEptyoA_yixCFOxXnANedT62v3IEQGG_ztQ0Su9pEK7hO4nFRhpUDSqAp7XZpPPwHOReMYYwk_d07UlzBAxr_xmt89hbSS8w_m58BO_Hx1McNkk2dq",
            "http://transcoder.baiducontent.com/tc?srd=1&dict=32&h5ad=1&bdenc=1&lid=8874999729740906145&title=&nsrc=IlPT2AEptyoA_yixCFOxXnANedT62v3IEQGG_ztQ0Su9pEK7hO4nFRhpUDSqAp73F9Cb9meEhMp2n8Kf_7Qm6so4g43",
            "http://transcoder.baiducontent.com/tc?srd=1&dict=32&h5ad=1&bdenc=1&lid=8874999729740906145&title=&nsrc=IlPT2AEptyoA_yixCFOxXnANedT62v3IEQGG_ztQ0Su9pEK7hO4nFRhpUDSqAp7yGlPwx8LLxBt8aSbvOi-27xZ0q_-qey6ylq",
            "http://transcoder.baiducontent.com/tc?srd=1&dict=32&h5ad=1&bdenc=1&lid=8874999729740906145&title=&nsrc=IlPT2AEptyoA_yixCFOxXnANedT62v3IEQGG_ztQ0Su9pEK7hO4nFRhpUDSqAp7XZpPPwHOReMYYwk_d07UlzBAxr_xptX9hbSS8w_m58BOBJB1YcNkk2dq",
            "http://transcoder.baiducontent.com/tc?srd=1&dict=32&h5ad=1&bdenc=1&lid=8874999729740906145&title=&nsrc=IlPT2AEptyoA_yixCFOxXnANedT62v3IEQGG_ztQ0Su9pEK7hO4nFRhpUDSqAp7yGlPwx8LQxBt8aSbvOi-27x2DtK-qey6ylq",
            "http://transcoder.baiducontent.com/tc?srd=1&dict=32&h5ad=1&bdenc=1&lid=8874999729740906145&title=&nsrc=IlPT2AEptyoA_yixCFOxXnANedT62v3IEQGG_ztQ0Su9pEK7hO4nFRhpUDSqAp73F9Cb9meEhMp2n8Kc_GQj6so4g43",
            "http://transcoder.baiducontent.com/tc?srd=1&dict=32&h5ad=1&bdenc=1&lid=8874999729740906145&title=&nsrc=IlPT2AEptyoA_yixCFOxXnANedT62v3IEQGG_ztQ0Su9pEK7hO4nFRhpUDSqAp7XZpPPwHOReMYYwk_d07UlzBAxr_xpsn9hbSS8w_m58BOBJRYQcNkk2dq",
            "http://transcoder.baiducontent.com/tc?srd=1&dict=32&h5ad=1&bdenc=1&lid=8874999729740906145&title=&nsrc=IlPT2AEptyoA_yixCFOxXnANedT62v3IEQGG_ztQ0Su9pEK7hO4nFRhpUDSqAp73F9Cb9meEhMp2n8Kf07Ap6so4g43",
            "http://transcoder.baiducontent.com/tc?srd=1&dict=32&h5ad=1&bdenc=1&lid=8874999729740906145&title=&nsrc=IlPT2AEptyoA_yixCFOxXnANedT62v3IEQGG_ztQ0Su9pEK7hO4nFRhpUDSqAp73F9Cb9meEhMp2n8Kf0G9k6so4g43",
            "http://transcoder.baiducontent.com/tc?srd=1&dict=32&h5ad=1&bdenc=1&lid=8874999729740906145&title=&nsrc=IlPT2AEptyoA_yixCFOxXnANedT62v3IEQGG_ztQ0Su9pEK7hO4nFRhpUDSqAp73F9Cb9meEhMp2n8Kf0WEn6so4g43",
            "http://transcoder.baiducontent.com/tc?srd=1&dict=32&h5ad=1&bdenc=1&lid=8874999729740906145&title=&nsrc=IlPT2AEptyoA_yixCFOxXnANedT62v3IEQGG_ztQ0Su9pEK7hO4nFRhpUDSqAp7yGlPwx8LQxBt8aSbvOi-27xZ0r_lqey6ylq",
            "http://transcoder.baiducontent.com/tc?srd=1&dict=32&h5ad=1&bdenc=1&lid=8874999729740906145&title=&nsrc=IlPT2AEptyoA_yixCFOxXnANedT62v3IEQGG_ztQ0Su9pEK7hO4nFRhpUDSqAp7yGlPwx8LRxBt8aSbvOi-27x2CtKxqey6ylq",
    };
}
