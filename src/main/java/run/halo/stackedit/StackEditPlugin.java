package run.halo.stackedit;

import org.springframework.stereotype.Component;

import run.halo.app.plugin.BasePlugin;
import run.halo.app.plugin.PluginContext;

/**
 * @author ryanwang
 * @since 2.0.0
 */
@Component
public class StackEditPlugin extends BasePlugin {

    public StackEditPlugin(PluginContext context) {
        super(context);
    }

    @Override
    public void start() {
    }

    @Override
    public void stop() {
    }
}
