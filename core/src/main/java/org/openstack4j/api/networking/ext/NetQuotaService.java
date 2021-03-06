package org.openstack4j.api.networking.ext;

import java.util.List;
import org.openstack4j.common.RestService;
import org.openstack4j.model.compute.ActionResponse;
import org.openstack4j.model.network.NetQuota;
import org.openstack4j.model.network.builder.NetQuotaBuilder;

/**
 * Networking (Neutron) Quota Extension API
 * 
 * @author Jeremy Unruh
 */
public interface NetQuotaService extends RestService {
    
    /**
     * Fetches the network quotas for the current tenant
     * 
     * @param tenantId
     * @return the tenants quota
     */
    NetQuota get(String tenantId);
    
//    List<? extends NetQuota> list();
    
    /**
     * Updates the network quotas for the current tenant
     * 
     * @param netQuota the net quota to update
     * @return the updated network quota
     * @see NetQuotaBuilder
     */
    NetQuota update(NetQuota netQuota);
    
    /**
     * Resets the current network quota for the current tenant back to defaults
     * @return the action response
     */
    ActionResponse reset();
    

    /**
     * update the quotaset based on tenant 
     * 
     * @param netQuota
     * @param tenantId
     * @return 
     */
    NetQuota put(NetQuota netQuota, String tenantId);

}
