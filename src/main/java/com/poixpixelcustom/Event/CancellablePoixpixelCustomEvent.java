package com.poixpixelcustom.Event;

import org.bukkit.Bukkit;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;

import com.poixpixelcustom.util.BukkitTools;
import com.poixpixelcustom.Exceptions.CancelledEventException;
import com.poixpixelcustom.Confirmations.ConfirmationBuilder;

/**
 * A class extended by PoixpixelCustomEvents Events which are Cancellable and which contain a
 * cancelMessage.
 * <p>
 * Having a getCancelMessage() available to us allows us to throw a
 * {@link CancelledEventException} which can use the cancelMessage in feedback
 * messaging or logging.
 * <p>
 * Used primarily in the
 * {@link ConfirmationBuilder#setCancellableEvent(CancellablePoixpixelCustomEvent)} and
 * {@link BukkitTools#ifCancelledThenThrow(CancellablePoixpixelCustomEvent)} code.
 *
 * @author LlmDL
 * @since 0.98.4.0.
 */
public abstract class CancellablePoixpixelCustomEvent extends Event implements Cancellable {

    private boolean isCancelled = false;
    private String cancelMessage = "Sorry, this event was cancelled.";

    public CancellablePoixpixelCustomEvent() {
        super();
    }

    /**
     * @return true if this event is cancelled.
     */
    @Override
    public boolean isCancelled() {
        return isCancelled;
    }

    /**
     * Sets the event to be cancelled or not.
     *
     * @param cancelled true will cancel the event.
     */
    @Override
    public void setCancelled(boolean cancelled) {
        isCancelled = cancelled;
    }

    /**
     * @return cancelMessage a String which will be displayed to the player/sender
     *         informing them that the action they commited is being denied, if
     *         cancelMessage is blank then no message will be displayed.
     */
    public String getCancelMessage() {
        return cancelMessage;
    }

    /**
     * Sets the cancellation message which will display to the player. Set to "" to
     * display nothing.
     *
     * @param msg cancelMessage to display as feedback.
     */
    public void setCancelMessage(String msg) {
        this.cancelMessage = msg;
    }

}
