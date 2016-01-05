/**
 * 
 */
package com.huihuan.eme;

/**
 * @author 任宏涛， ren@ecust.edu.cn
 *
 * @created 2016年1月5日 下午10:06:16
 *
 */
import org.springframework.security.acls.model.AclCache;
import org.springframework.security.acls.model.MutableAcl;
import org.springframework.security.acls.model.ObjectIdentity;
import java.io.Serializable;

public class NullAclCache implements AclCache {

    public void evictFromCache(Serializable pk) {

    }

    public void evictFromCache(ObjectIdentity objectIdentity) {

    }

    public MutableAcl getFromCache(ObjectIdentity objectIdentity) {
        return null;
    }

    public MutableAcl getFromCache(Serializable pk) {
        return null;
    }

    public void putInCache(MutableAcl acl) {

    }

    public void clearCache() {

    }
}