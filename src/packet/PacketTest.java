package packet;

import static org.junit.Assert.*;

import org.junit.Test;

import pixel.Pixel;
import util.Pair;

public class PacketTest {
    
    @Test
    public void newClientPacketTest() {
        // Create a NewClientPacket, convert it to data, and ensure that
        // the reconstructed packet is identical to the original packet.
        
        Packet packet = new PacketNewClient(2, "id", "name");
        String data = packet.data();
        PacketNewClient newPacket = (PacketNewClient) Packet.createPacketWithData(data);
        
        assertEquals(packet, newPacket);
        assertEquals(packet.hashCode(), newPacket.hashCode());
        
        assertTrue(newPacket.id().equals("id"));
        assertTrue(newPacket.name().equals("name"));
        assertTrue(newPacket.boardID() == 2);
    }
    
    @Test
    public void disconnectClientPacketTest() {
        // Create a DisconnectClientPacket, convert it to data, and ensure that
        // the reconstructed packet is identical to the original packet.
        
        Packet packet = new PacketDisconnectClient(3, "id", "name");
        String data = packet.data();
        PacketDisconnectClient newPacket = (PacketDisconnectClient) Packet.createPacketWithData(data);
        
        assertEquals(packet, newPacket);
        assertEquals(packet.hashCode(), newPacket.hashCode());
        
        assertTrue(newPacket.id().equals("id"));
        assertTrue(newPacket.name().equals("name"));
    }
    
    @Test
    public void gameStatePacketTest() {
        @SuppressWarnings("unchecked")
        Pair<String, String>[] clients = new Pair[2];
        
        clients[0] = new Pair<String, String>("id1", "name1");
        clients[1] = new Pair<String, String>("id1", "name1");
        
        Pixel[] pixels = new Pixel[2];
        pixels[0] = new Pixel(0, 0, "white");
        pixels[1] = new Pixel(1, 2, "black");
        
        Packet packet = new PacketGameState(100, clients, pixels);
        String data = packet.data();
        PacketGameState newPacket = (PacketGameState) Packet.createPacketWithData(data);
        
        assertEquals(packet, newPacket);
        assertEquals(packet.hashCode(), newPacket.hashCode());
        assertArrayEquals(newPacket.clients(), clients);
        assertArrayEquals(newPacket.pixels(), pixels);
    }

    @Test
    public void drawPixelPacketTest() {
        Pixel whitePixel = new Pixel(0, 0, "white");
        
        Packet packet = new PacketDrawPixel(13, whitePixel);
        String data = packet.data();
        PacketDrawPixel newPacket = (PacketDrawPixel) Packet.createPacketWithData(data);
        
        assertEquals(packet, newPacket);
        assertEquals(packet.hashCode(), newPacket.hashCode());
        assertEquals(newPacket.pixel(), whitePixel);
    }
    
    @Test
    public void differentPacketTest() {
        // Assert that different packets produce different data.
        
        Packet packet1 = new PacketNewClient(2, "id", "name");
        Packet packet2 = new PacketDisconnectClient(2, "id", "name");
        Packet packet3 = new PacketNewClient(2, "id2", "name2");
        
        assertFalse(packet1.data().equals(packet2.data()));
        assertFalse(packet1.data().equals(packet3.data()));
    }
}