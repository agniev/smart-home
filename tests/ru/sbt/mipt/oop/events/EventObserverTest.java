package ru.sbt.mipt.oop.events;

import org.junit.Before;
import org.junit.Test;
import ru.sbt.mipt.oop.entities.SmartHome;
import ru.sbt.mipt.oop.sensors.handlers.AutoEventHandler;
import ru.sbt.mipt.oop.sensors.handlers.DoorsEventHandler;
import ru.sbt.mipt.oop.sensors.handlers.LightsEventHandler;

import java.util.Arrays;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by Roman on 17.12.2017.
 */
public class EventObserverTest {
    EventObserver eventObserver;
    SmartHome smartHomeMock;
    DoorsEventHandler doorsEventHandlerMock;
    LightsEventHandler lightsEventHandlerMock;
    AutoEventHandler autoEventHandlerMock;

    @Before
    public void setUp() throws Exception {
        doorsEventHandlerMock = mock(DoorsEventHandler.class);
        lightsEventHandlerMock = mock(LightsEventHandler.class);
        autoEventHandlerMock = mock(AutoEventHandler.class);
        smartHomeMock = mock(SmartHome.class);
        eventObserver = new EventObserver(smartHomeMock);
        eventObserver.setEventHandlers(
                Arrays.asList(doorsEventHandlerMock, lightsEventHandlerMock, autoEventHandlerMock));
    }

    @Test
    public void handleEvent() throws Exception {
        Event eventMock = mock(Event.class);
        eventObserver.handleEvent(eventMock);

        verify(doorsEventHandlerMock).handle(smartHomeMock, eventMock);
        verify(lightsEventHandlerMock).handle(smartHomeMock, eventMock);
        verify(autoEventHandlerMock).handle(smartHomeMock, eventMock);
    }
}