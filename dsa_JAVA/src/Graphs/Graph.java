package Graphs;

import java.util.Scanner;

//DFS
public class Graph {

	public static void DFSHelper(int edges[][], int sv, boolean visited[]) {
		System.out.println(sv);
		visited[sv] = true;
		int n = edges.length;
		for(int i = 0; i < n ; i++) {
			if(edges[sv][i] == 1 && !visited[i]) {
				//edge present
				DFSHelper(edges, i,visited);
			}
		}
	}
	
	public static void DFS(int edges[][]) {
		boolean visited[] = new boolean[edges.length];
		for(int i = 0 ; i < visited.length; i++) {
			if(!visited[i]) {
				DFSHelper(edges, i, visited);			
			}
		}
	}
	
	
	public static void BFSHelper(int edges[][], int sv, boolean visited[]) throws QueueEmptyException {
		
		QueueUsingLL<Integer> q = new QueueUsingLL<>();
		
		q.enqueue(sv);
		visited[sv] = true;
		
		while(!q.isEmpty()) {
			int front = q.dequeue();
			System.out.println(front);
			for(int i =0 ; i < edges.length ; i++) {
				//get edges and add to queue
				if(edges[front][i] == 1 && !visited[i]) {
					q.enqueue(i);
					visited[i] = true;
				}
			}
		}
	}


	private static void BFS(int edges[][]) {
		// TODO Auto-generated method stub
		boolean visited[] = new boolean[edges.length];
		try {
			for(int i = 0 ; i < visited.length; i++) {
				if(!visited[i]) {
					BFSHelper(edges, i ,visited);			
				}
			}
			
			
		} catch (QueueEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//n - vertices
		int n;
		//e - edges
		int e;
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		e = sc.nextInt();
		
		//by default 0
		int edges[][] = new int[n][n];
		
		//get e edges
		for(int i= 0 ; i < e;  i++) {
			int fv = sc.nextInt();
			int sv = sc.nextInt();
			edges[fv][sv] = 1;
			edges[sv][fv] = 1;
		}

		System.out.println("\nDFS:\n");
		DFS(edges);
		System.out.println("\nBFS:\n");
		BFS(edges);
	}


}
