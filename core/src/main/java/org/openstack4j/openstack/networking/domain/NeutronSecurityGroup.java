package org.openstack4j.openstack.networking.domain;

import java.util.List;

import org.openstack4j.model.network.SecurityGroup;
import org.openstack4j.model.network.SecurityGroupRule;
import org.openstack4j.model.network.builder.NetSecurityGroupBuilder;
import org.openstack4j.openstack.common.ListResult;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.google.common.base.Objects;

/**
 * An OpenStack Neutron Security Group Rule model.
 *
 * @author Nathan Anderson
 */
@JsonRootName("security_group")
public class NeutronSecurityGroup implements SecurityGroup {
  
	private static final long serialVersionUID = 1L;

	@JsonProperty("id")
  private String id;
  
  @JsonProperty("tenant_id")
  private String tenantId;
  
  @JsonProperty("description")
  private String description;
  
  @JsonProperty("name")
  private String name;
  
  @JsonProperty("security_group_rules")
  private List<NeutronSecurityGroupRule> rules;
  
        /**
	 * Security Groups only need two fields populated when Updated so instead of a builder the API can
	 * leverage this call to update a existing Security Group
	 * 
	 * @param name name of the security group
	 * @param description description of the security group
	 * @return
	 */
	public static NeutronSecurityGroup update(String name, String description) {
		NeutronSecurityGroup sg = new NeutronSecurityGroup();
		sg.name = name;
		sg.description = description;
		return sg;
	}
  
  /**
   * {@inheritDoc}
   */
  @Override
  public String getDescription() {
    return this.description;
  }

  
  /**
   * {@inheritDoc}
   */
  @Override
  public String getId() {
    return this.id;
  }
  
  /**
   * {@inheritDoc}
   */
  @Override
  public String getTenantId() {
    return this.tenantId;
  }


  /**
   * {@inheritDoc}
   */
  @Override
  public String getName() {
    return this.name;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setId(String id) {
    this.id = id;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setName(String name) {
    this.name = name;
  }
  
  /**
   * {@inheritDoc}
   */
  @Override
  public void setTenantId(String tenantId) {
    this.tenantId = tenantId;
  }

  
  /**
   * {@inheritDoc}
   */
  @Override
  public List<? extends SecurityGroupRule> getRules() {
    return rules;
  }
  
  /**
   * {@inheritDoc}
   */
  @Override
  public NetSecurityGroupBuilder toBuilder() {
    return new SecurityGroupConcreteBuilder(this);
  }
  
  public static NetSecurityGroupBuilder builder() {
    return new SecurityGroupConcreteBuilder();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    return Objects.toStringHelper(this).omitNullValues()
            .add("id", id).add("tenantId", tenantId)
            .add("name", name)
            .add("description", description)
            .add("security_group_rules", rules)
            .addValue("\n")
            .toString();
  }
  
  /**
   * The Class SecurityGroups.
   *
   * @author Nathan Anderson
   */
  public static class SecurityGroups extends ListResult<NeutronSecurityGroup> {
    
    private static final long serialVersionUID = 1L;

    @JsonProperty("security_groups")
    private List<NeutronSecurityGroup> rules;
    
    /**
     * {@inheritDoc}
     */
    @Override
    protected List<NeutronSecurityGroup> value() {
      return rules;
    }
  }
  
  /**
   * The Class SecurityGroupConcreteBuilder.
   * 
   *
   * @author Nathan Anderson
   */
  public static class SecurityGroupConcreteBuilder implements NetSecurityGroupBuilder {
    
    NeutronSecurityGroup g;
    
    /**
     * Instantiates a new security group rule concrete builder.
     */
    public SecurityGroupConcreteBuilder() {
      g = new NeutronSecurityGroup();
    }
    
    /**
     * Instantiates a new security group rule concrete builder.
     *
     * @param rule the rule
     */
    public SecurityGroupConcreteBuilder(SecurityGroup in) {
      g = (NeutronSecurityGroup) in;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public SecurityGroup build() {
      return g;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NetSecurityGroupBuilder from(SecurityGroup in) {
      g = (NeutronSecurityGroup) in;
      return this;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public NetSecurityGroupBuilder name(String name) {
      g.name = name;
      return this;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public NetSecurityGroupBuilder description(String description) {
      g.description = description;
      return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NetSecurityGroupBuilder id(String id) {
      g.id = id;
      return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NetSecurityGroupBuilder tenantId(String tenantId) {
      g.tenantId = tenantId;
      return this;
    }
  }
}
