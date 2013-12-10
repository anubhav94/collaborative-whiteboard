package packet;
/**
 * Interface to handle different types of packets
 * 
 *
 */
public interface PacketHandler {
     void receivedNewClientPacket(PacketNewClient packet);
     void receivedNewBoardPacket(PacketNewBoard packet);
     void receivedClientReadyPacket(PacketClientReady packet);
     void receivedJoinBoardPacket(PacketJoinBoard packet);
     void receivedExitBoardPacket(PacketExitBoard packet);
     void receivedBoardModelPacket(PacketBoardModel packet);
     void receivedBoardUsersPacket(PacketBoardUsers packet);
     void receivedBoardIdentifierListPacket(PacketBoardIdentifierList packet);
     void receivedDrawCommandPacket(PacketDrawCommand packet);
     void receivedMessagePacket(PacketMessage packet);
     void receivedLayerOrderListPacket(PacketLayerOrderList packetLayerOrderList);
     void receivedNewLayerPacket(PacketNewLayer packetNewLayer);
}
