package hudson.plugins.scm_sync_configuration.data;

import static org.easymock.EasyMock.isNull;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import hudson.plugins.scm_sync_configuration.ScmSyncConfigurationPlugin;
import hudson.plugins.scm_sync_configuration.scms.impl.ScmSyncSubversionSCM;
import hudson.plugins.scm_sync_configuration.util.ScmSyncConfigurationPluginBaseTest;

import org.junit.Test;

public class V0_0_2CompatibilityTest extends ScmSyncConfigurationPluginBaseTest {

	protected String getHudsonRootBaseTemplate() {
		return "hudsonRoot0.0.2BaseTemplate/";
	}
	
	@Test
	// JENKINS-8453 related
	public void should0_0_2_pluginConfigurationFileShouldLoadCorrectly() throws Throwable {
		ScmSyncConfigurationPlugin plugin = ScmSyncConfigurationPlugin.getInstance();
		assertThat(plugin.getSCM(), not(isNull()));
		assertThat(plugin.getSCM().getId(), is(equalTo(ScmSyncSubversionSCM.class.getName())));
	}
}
