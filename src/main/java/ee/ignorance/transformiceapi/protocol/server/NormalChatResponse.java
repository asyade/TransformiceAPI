package ee.ignorance.transformiceapi.protocol.server;

import ee.ignorance.transformiceapi.processors.AbstractProcessor;
import ee.ignorance.transformiceapi.processors.NormalChatProcessor;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

public class NormalChatResponse extends AbstractResponse {

        private String sender;
        private String message;

        public NormalChatResponse(byte[] rawMessage) {
                super(rawMessage);
        }

        @Override
        public void parse(byte[] rawMessage) {
                DataInputStream in = new DataInputStream(new ByteArrayInputStream(rawMessage));
                try {
                        int playerCode = in.readInt();
                        sender = in.readUTF();
                        message = in.readUTF();
                } catch (Exception e) {
                        e.printStackTrace();
                }
        }

        public String getSender() {
                return sender;
        }

        public String getMessage() {
                return message;
        }

        @Override
        public AbstractProcessor getProcessor() {
                return new NormalChatProcessor();
        }
}
