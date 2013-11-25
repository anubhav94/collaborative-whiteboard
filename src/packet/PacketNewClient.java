package packet;

import java.util.HashMap;

import com.google.gson.JsonObject;

public final class PacketNewClient extends Packet {
    private final String name;
    private final String id;
    
    /**
     * 
     * @param data JSON representation of the data.
     * @return the constructed Packet
     */
    protected static Packet createPacketWithDataInternal(JsonObject data) {
        int boardID = data.get("boardID").getAsInt();
        
        String id = data.get("id").getAsString();
        String name = data.get("name").getAsString();
        return new PacketNewClient(boardID, id, name);
    }
    
    public PacketNewClient(int boardID, String id, String name) {
        super(PacketType.PacketTypeNewClient, boardID);
        this.id = id;
        this.name = name;
    }
    
    /**
     * See specification in superclass.
     */
    @Override
    protected void addPayloadToData(HashMap<Object, Object> data) {
        data.put("name", name);
        data.put("id", id);
    }

    public String id() {
        return id;
    }

    public String name() {
        return name;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        PacketNewClient other = (PacketNewClient) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }
    
}