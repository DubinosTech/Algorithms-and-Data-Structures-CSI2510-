public class TestCompressedTrie2
{

	//Initialisation de l objet Mytrie()
	
public static void main(String[] args) {
	

	MyTrie trie=new MyTrie();

	//Insertion de la methode insert
    System.out.println("-----------Insertion des noeuds ----------");
  
   if(trie.insert("0"))
   	  { System.out.println("La chaine 0 a ete implementer dans le trie");}
   
   if(trie.insert("111"))
   	   {System.out.println("La chaine 111 a ete implementerdans le trie");}
   
    if(trie.insert("01"))
   	   {System.out.println("La chaine 01 a ete implementer dans le trie");}
   
        if(trie.insert("011"))
   	          {System.out.println("La chaine 011 a ete implementer dans le trie");}
  
    if(trie.insert("0100"))
   	   {System.out.println("La chaine 0100 a ete implementer dans le trie");}
   
   if(trie.insert("0101"))
   	   {System.out.println("La chaine 0101 a ete implementer dans le trie");}
  // appel de compressedTrie constructor
     MyCompressedTrie comp=new MyCompressedTrie( trie);


   
// Impression lexicographique
    System.out.println("-----------Impression lexicographique----------");
   comp.printStringsInLexicoOrder();





} }