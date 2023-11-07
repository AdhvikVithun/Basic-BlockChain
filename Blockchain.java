import java.util.ArrayList;

class Blockchain{
    private ArrayList<Block> chain;

    public Blockchain() {
        chain = new ArrayList<>();
        chain.add(createGenesisBlock());
    }

    private Block createGenesisBlock() {
        return new Block("Genesis Block", "0");
    }

    public Block getLatestBlock() {
        return chain.get(chain.size() - 1);
    }

    public void addBlock(String data) {
        Block latestBlock = getLatestBlock();
        chain.add(new Block(data, latestBlock.getHash()));
    }

    public ArrayList<Block> getChain() {
        return chain;
    }
}