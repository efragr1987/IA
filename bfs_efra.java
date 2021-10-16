
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
 
public class bfs_efra
{
    private Queue<nodo> cola;
    static ArrayList<nodo> nodes=new ArrayList<nodo>();
    static class nodo
    {
        String data;
        boolean visitados;
        List<nodo> vecinos;
 
        nodo(String data)
        {
            this.data=data;
            this.vecinos=new ArrayList<>();
        }
        public void addvecino(nodo nodovecino)
        {
            this.vecinos.add(nodovecino);
        }
        public List<nodo> getvecino() {
            return vecinos;
        }
        public void setvecino(List<nodo> vecinos) {
            this.vecinos = vecinos;
        }
    }
 
    public bfs_efra()
    {
        cola = new LinkedList<nodo>();
    }
    public void bfs(nodo node)
    {
        int a = 1;
        cola.add(node);
        node.visitados=true;
        while (!cola.isEmpty())
        {
            nodo element=cola.remove();
            System.out.print(element.data);
            if (a == 1){System.out.print(" -> ");}
            List<nodo> vecinos=element.getvecino();
            for (int i = 0; i < vecinos.size(); i++) {
                nodo n=vecinos.get(i);
                if(n!=null && !n.visitados)
                {
                    cola.add(n);
                    n.visitados=true;
                    a = 1;


                }
                else {a = 2;}
                
            }
              
        }
    }
     public static void main(String arg[])
    {
        nodo nodeS =new nodo("S");
        nodo nodeA =new nodo("A");
        nodo nodeD =new nodo("D");
        nodo nodeB =new nodo("B");
        nodo nodeE =new nodo("E");
        nodo nodeC =new nodo("C");
        nodo nodeF =new nodo("F");
        nodo nodeG =new nodo("G");
        
        nodeS.addvecino(nodeD);
        nodeS.addvecino(nodeA);
        nodeA.addvecino(nodeS);
        nodeA.addvecino(nodeD);
        nodeA.addvecino(nodeB);
        nodeD.addvecino(nodeS);
        nodeD.addvecino(nodeA);
        nodeD.addvecino(nodeE);
        nodeB.addvecino(nodeA);
        nodeB.addvecino(nodeE);
        nodeB.addvecino(nodeC);
        nodeE.addvecino(nodeD);
        nodeE.addvecino(nodeB);
        nodeE.addvecino(nodeF);
        nodeC.addvecino(nodeB);
        nodeF.addvecino(nodeE);
        nodeF.addvecino(nodeG);
        nodeG.addvecino(nodeF);
    
        System.out.println("BFS: ");
        bfs_efra bfsExample = new bfs_efra();
        bfsExample.bfs(nodeS);
 
    }
}