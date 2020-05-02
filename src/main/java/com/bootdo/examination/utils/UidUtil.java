package com.bootdo.examination.utils;

public class UidUtil {
	//private Logger logger = LoggerFactory.getLogger(UidUtil.class);
	private static final String NODE_ID = "11";
	
	volatile private static SnowflakeIdWorker idWorker;
	
	private static class UidUtilHolder{  
        //单例变量    
        private static UidUtil instance = new UidUtil();  
    }  
      
    //私有化的构造方法，保证外部的类不能通过构造器来实例化。  
    private UidUtil() {  
    	idWorker = new SnowflakeIdWorker(Integer.valueOf(NODE_ID), 0);
    } 
    /**
	 * 线程安全的 单例
	 * @return
	 */
    public static UidUtil getInstance() {  
        return UidUtilHolder.instance;  
    }  
	
	public String getUid(){
		long uid = idWorker.nextId();
		return String.valueOf(uid);
	}
	
	public Long getLongUid(){
		long uid = idWorker.nextId();
		return uid;
	}
	
	public String getLenUid(int len){
		String uid = String.valueOf(idWorker.nextId());
		int strLen = uid.length();
		return String.valueOf(uid.substring(strLen-len, strLen));
	}
	
	 /** 测试 */
    public static void main(String[] args) {
    	for(int i=0;i<100;i++) {
    		System.out.println(UidUtil.getInstance().getUid());
    	}
    	
        
    }

}
