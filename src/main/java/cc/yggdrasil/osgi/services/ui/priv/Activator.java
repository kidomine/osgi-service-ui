package cc.yggdrasil.osgi.services.ui.priv;

import org.osgi.framework.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Activator implements BundleActivator
{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void start(final BundleContext bundleContext) throws Exception
    {
        logger.info("Starting UI services...");
    }

    @Override
    public void stop(final BundleContext bundleContext) throws Exception
    {
        logger.info("Stopping UI services...");
    }
}
