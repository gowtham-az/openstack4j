package org.openstack4j.openstack.networking.domain;

import static com.google.common.base.Objects.toStringHelper;

import org.openstack4j.model.network.NetQuota;
import org.openstack4j.model.network.builder.NetQuotaBuilder;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * Network quotas that are bound to a Tenant
 * 
 * @author Jeremy Unruh
 */
@JsonRootName("quota")
public class NeutronNetQuota implements NetQuota {

    private static final long serialVersionUID = 1L;
    
    
    private int subnet;
    
    private int router;
    
    private int port;
    
    private int network;
    
    @JsonProperty("floatingip")
    private int floatingIp;

    public static NetQuotaBuilder builder() {
        return new NetQuotaConcreteBuilder();
    }
    
    @Override
    public NetQuotaBuilder toBuilder() {
        return new NetQuotaConcreteBuilder(this);
    }
    
    @Override
    public int getSubnet() {
        return subnet;
    }

    @Override
    public int getRouter() {
        return router;
    }

    @Override
    public int getPort() {
        return port;
    }

    @Override
    public int getNetwork() {
        return network;
    }

    @JsonIgnore
    @Override
    public int getFloatingIP() {
        return floatingIp;
    }
    
    @Override
    public String toString() {
        return toStringHelper(this)
                .add("subnet", subnet).add("router", router).add("port", port)
                .add("network", network).add("floatingIp", floatingIp)
                .toString();
    }

    public static class NetQuotaConcreteBuilder implements NetQuotaBuilder {

        private NeutronNetQuota model;
        
        public NetQuotaConcreteBuilder() {
            model = new NeutronNetQuota();
        }
        
        public NetQuotaConcreteBuilder(NeutronNetQuota model) {
            this.model = model;
        }
        
        @Override
        public NetQuota build() {
            return model;
        }

        @Override
        public NetQuotaBuilder from(NetQuota in) {
            model = (NeutronNetQuota) in;
            return this;
        }

        @Override
        public NetQuotaBuilder subnet(int subnet) {
            model.subnet = subnet;
            return this;
        }

        @Override
        public NetQuotaBuilder router(int router) {
            model.router = router;
            return this;
        }

        @Override
        public NetQuotaBuilder port(int port) {
            model.port = port;
            return this;
        }

        @Override
        public NetQuotaBuilder network(int network) {
            model.network = network;
            return this;
        }

        @Override
        public NetQuotaBuilder floatingIP(int floatingIP) {
            model.floatingIp = floatingIP;
            return this;
        }
        
    }
    
}
