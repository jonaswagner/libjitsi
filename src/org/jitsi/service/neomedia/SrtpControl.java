/*
 * Jitsi, the OpenSource Java VoIP and Instant Messaging client.
 *
 * Distributable under LGPL license.
 * See terms of license at gnu.org.
 */
package org.jitsi.service.neomedia;

import org.jitsi.impl.neomedia.*;
import org.jitsi.impl.neomedia.transform.*;
import org.jitsi.service.neomedia.event.*;

/**
 * Controls SRTP encryption in the MediaStream.
 *
 * @author Damian Minkov
 */
public interface SrtpControl
{
    /**
     * Cleans up the current SRTP control and its engine.
     */
    public void cleanup();

    /**
     * Gets the default secure/insecure communication status for the supported
     * call sessions.
     *
     * @return default secure communication status for the supported call
     * sessions.
     */
    public boolean getSecureCommunicationStatus();

    /**
     * Returns the <tt>SrtpListener</tt> which listens for security events.
     *
     * @return the <tt>SrtpListener</tt> which listens for security events
     */
    public SrtpListener getSrtpListener();

    /**
     * Returns the transform engine currently used by this stream.
     *
     * @return the RTP stream transformation engine
     */
    public TransformEngine getTransformEngine();

    /**
     * Indicates if the key exchange method is dependent on secure transport of
     * the signaling channel.
     *
     * @return <tt>true</tt> when secure signaling is required to make the
     * encryption secure; <tt>false</tt>, otherwise.
     */
    public boolean requiresSecureSignalingTransport();

    /**
     * Sets the <tt>RTPConnector</tt> which is to use or uses this SRTP engine.
     *
     * @param connector the <tt>RTPConnector</tt> which is to use or uses this
     * SRTP engine
     */
    public void setConnector(AbstractRTPConnector connector);

    /**
     * When in multistream mode, enables the master session.
     *
     * @param masterSession whether current control, controls the master session.
     */
    public void setMasterSession(boolean masterSession);

    /**
     * Sets the multistream data, which means that the master stream has
     * successfully started and this will start all other streams in this
     * session.
     *
     * @param master The security control of the master stream.
     */
    public void setMultistream(SrtpControl master);

    /**
     * Sets a <tt>SrtpListener</tt> that will listen for security events.
     *
     * @param srtpListener the <tt>SrtpListener</tt> that will receive the
     * events
     */
    public void setSrtpListener(SrtpListener srtpListener);

    /**
     * Starts and enables zrtp in the stream holding this control.
     *
     * @param mediaType the media type of the stream this control controls.
     */
    public void start(MediaType mediaType);
}
