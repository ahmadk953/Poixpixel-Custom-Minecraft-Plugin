package com.poixpixelcustom.Confirmations;

import org.bukkit.command.CommandSender;

import com.poixpixelcustom.PoixpixelCustomSettings;
import com.poixpixelcustom.Event.CancellablePoixpixelCustomEvent;


public class ConfirmationBuilder {

    Runnable acceptHandler;
    Runnable cancelHandler;
    private String title = "are_you_sure_you_want_to_continue";
    String confirmCommand = PoixpixelCustomSettings.getConfirmCommand();
    String cancelCommand = PoixpixelCustomSettings.getCancelCommand();
    String pluginPrefix = "poixpixelcustom";
    int duration = PoixpixelCustomSettings.getConfirmationTimeoutSeconds();
    boolean runAsync;
    CancellablePoixpixelCustomEvent event;

    /**
     * The code to run on cancellation.
     *
     * @param cancelHandler The runnable to run on cancellation of the confirmation.
     * @return A builder reference of this object.
     */
    public ConfirmationBuilder runOnCancel(Runnable cancelHandler) {
        this.cancelHandler = cancelHandler;
        return this;
    }

    /**
     * Sets the title of the confirmation to be sent.
     *
     * @param title The title of the confirmation.
     * @return A builder reference of this object.
     * @deprecated since 0.97.3.0 - Use {@link#setTitle(Translatable)} instead.
     */
    @Deprecated
    public ConfirmationBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     * Sets the duration the confirmation will run for.
     *
     * @param duration The duration in second.
     * @return A builder reference of this object.
     */
    public ConfirmationBuilder setDuration(int duration) {
        this.duration = duration;
        return this;
    }

    public ConfirmationBuilder setCancellableEvent(CancellablePoixpixelCustomEvent event) {
        this.event = event;
        return this;
    }

    /**
     * Sets whether the confirmation will run it's accept handler
     * async or not.
     *
     * @param runAsync Whether to run async or not.
     * @return A builder reference of this object.
     */
    public ConfirmationBuilder setAsync(boolean runAsync) {
        this.runAsync = runAsync;
        return this;
    }

    /**
     * Sets the command which is displayed/run for the confirm command.
     * @param confirm String command name.
     * @return ConfirmationBuilder with an overridden confirm text.
     */
    public ConfirmationBuilder setConfirmText(String confirm) {
        this.confirmCommand = confirm;
        return this;
    }

    /**
     * Sets the command which is displayed/run for the cancel command.
     * @param cancel String command name.
     * @return ConfirmationBuilder with an overriden cancel text.
     */
    public ConfirmationBuilder setCancelText(String cancel) {
        this.cancelCommand = cancel;
        return this;
    }

    /**
     * Sets the base plugin command used when the cancel or confirm commands are run.
     * @param prefix String plugin name sending this Confirmation.
     * @return ConfirmationBuilder with an overriden command prefix.
     */
    public ConfirmationBuilder setPluginCommandPrefix(String prefix) {
        this.pluginPrefix = prefix;
        return this;
    }

    /**
     * Builds a new instance of {@link Confirmation} from
     * this object's state.
     *
     * @return A new Confirmation object.
     */
    /**public Confirmation build() {
        return new Confirmation(this);
    }

    /**
     * Builds and sends this confirmation to the given CommandSender.
     *
     * @param sender The sender to send the confirmation to.
     */
    /**public void sendTo(CommandSender sender) {
        Confirmation confirmation = build();
        ConfirmationHandler.sendConfirmation(sender, confirmation);
    }
     */
}
