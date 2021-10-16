import java.util.ArrayList;
import java.util.List;
 
public class dfs_efra
{
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
        public void getvecino(List<nodo> vecinos) {
            this.vecinos = vecinos;
        }
    }
 
    // DFS Recursivo
    public  void dfs(nodo node)
    {
        System.out.print(node.data);
        List<nodo> vecinos=node.getvecino();
        node.visitados=true;
        for (int i = 0; i < vecinos.size(); i++) {
            nodo n=vecinos.get(i);
            if(n!=null && !n.visitados)
            {
                System.out.print(" -> ");
                dfs(n); // Ejecutamos profundizándonos en cada nodo
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
        
        nodeS.addvecino(nodeA);
        nodeS.addvecino(nodeD);
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
 
        dfs_efra dfsExample = new dfs_efra();
 
        // seteamos a todos los nodos como no visitados
        nodeS.visitados=false;
        nodeA.visitados=false;
        nodeD.visitados=false;
        nodeB.visitados=false;
        nodeE.visitados=false;
        nodeC.visitados=false;
        nodeE.visitados=false;
        nodeG.visitados=false;
        nodeF.visitados=false;
 
        System.out.println("DFS Recursivo :"); dfsExample.dfs(nodeS); // Empezamos en el nodo S
    }
}