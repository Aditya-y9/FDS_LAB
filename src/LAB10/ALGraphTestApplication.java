package LAB10;

import java.util.*;


public class ALGraphTestApplication {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
    System.out.println("<__________________________FoeBook__________________________>");
        int choice = 0;


        int choice1 = 0;
        while(choice1 != 3){
            System.out.println("1. Create a Adjacency List Graph"+ 
                                "\n2. Create a Adjacency Matrix Graph"+
                                "\n3. Create a Adjacency Map Graph");
            System.out.println("Enter your choice: ");

            Graph<Integer> FoeBook = new Graph<>();


        while(choice != 14){
            System.out.println("1. Add a user"+
                                "\n2. Get number of users"+
                                "\n3. Get users list"+
                                "\n4. Get number of Friendships"+
                                "\n5. Get Friendships list"+
                                "\n6. Check if two users are friends"+
                                "\n7. Get Friends list of a user"+
                                "\n8. Get following list of a user"+
                                "\n9. Get followers list of a user"+
                            "\n10. Get following count of a user"+
                            "\n11. Get followers count of a user"+
                            "\n12. Make a new account"+
                        "\n13. Make a new Friendship");
                        
            
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();
                    

                    switch(choice){
                        case 1:
                            System.out.println("Enter the name of user: ");
                            String userName = sc.next();
                            Vertex user = new Vertex(userName);
                            FoeBook.insertVertex(user);
                            break;
                        case 2:
                            System.out.println("Number of users: "+FoeBook.numVertices());
                            break;
                        case 3:
                            System.out.println("Users list: "+FoeBook.vertices());
                            break;
                        case 4:
                            System.out.println("Number of Friendships: "+FoeBook.numEdges());
                            break;
                        case 5:
                            System.out.println("Friendships list: "+FoeBook.edges());
                            break;
                        case 6:
                            boolean found = false;
                            System.out.println("Enter the name of user 1: ");
                            Vertex user1 = null;
                            Vertex user2 = null;
                            String userName1 = sc.next();
                            for(Vertex v : FoeBook.vertices()){
                                if(v.getElement().equals(userName1)){
                                    user1 = v;
                                    break;
                                }
                            }
                            if(user1 == null){
                                System.out.println("User not found");
                                break;
                            }
                            System.out.println("Enter the name of user 2: ");
                            String userName2 = sc.next();
                            for(Vertex v : FoeBook.vertices()){
                                if(v.getElement().equals(userName2)){
                                    user2 = v;
                                }
                            }
                            if(user2 == null){
                                System.out.println("User not found");
                                break;
                            }
                            if(FoeBook.getEdge(user1, user2) != null){
                                System.out.println("Yes, they are friends");
                            }
                            else{
                                System.out.println("No, they are not friends");
                            }
                            break;
                        case 7:
                            System.out.println("Enter the name of user: ");
                            String userName3 = sc.nextLine();
                            Vertex user3 = null;
                            for(Vertex v : FoeBook.vertices()){
                                if(v.getElement().equals(userName3)){
                                    System.out.println(v.getElement());
                                    user3 = v;
                                    break;
                                }
                                else{
                                    System.out.println("User not found");
                                }
                            }
                            List<Edge<Integer>> friends = FoeBook.outgoingEdges(user3);
                            System.out.println(user3.getElement() + "'s Friends:");
                            for (Edge<Integer> friend : friends) {
                                Vertex friendVertex = FoeBook.opposite(user3, friend);
                                System.out.println("- " + friendVertex.getElement() + " (Friendship Level: " + friend.getWeight() + ")");
                            }
                            break;
                        case 8:
                            System.out.println("Enter the name of user: ");
                            String userName4 = sc.nextLine();
                            Vertex user4 = new Vertex(userName4);
                            List<Edge<Integer>> following = FoeBook.outgoingEdges(user4);
                            System.out.println(user4.getElement() + "'s Following:");
                            for (Edge<Integer> follow : following) {
                                Vertex followVertex = FoeBook.opposite(user4, follow);
                                System.out.println("- " + followVertex.getElement() + " (Friendship Level: " + follow.getWeight() + ")");}
                        case 9:
                            System.out.println("Enter the name of user: ");
                            String userName5 = sc.nextLine();
                            Vertex user5 = new Vertex(userName5);
                            List<Edge<Integer>> followers = FoeBook.outgoingEdges(user5);
                            System.out.println(user5.getElement() + "'s Followers:");
                            for (Edge<Integer> follower : followers) {
                                Vertex followerVertex = FoeBook.opposite(user5, follower);
                                System.out.println("- " + followerVertex.getElement() + " (Friendship Level: " + follower.getWeight() + ")");
                            }
                            break;
                        case 10:
                            System.out.println("Enter the name of user: ");
                            String userName6 = sc.nextLine();
                            Vertex user6 = new Vertex(userName6);
                            List<Edge<Integer>> following1 = FoeBook.outgoingEdges(user6);
                            System.out.println(user6.getElement() + "'s Following:");
                            int count = 0;
                            for (Edge<Integer> follow : following1) {
                                Vertex followVertex = FoeBook.opposite(user6, follow);
                                count++;
                            }
                            System.out.println("Number of following: "+count);
                            break;
                        case 11:
                            System.out.println("Enter the name of user: ");
                            String userName7 = sc.nextLine();
                            Vertex user7 = new Vertex(userName7);
                            List<Edge<Integer>> followers1 = FoeBook.outgoingEdges(user7);
                            System.out.println(user7.getElement() + "'s Followers:");
                            int count1 = 0;
                            for (Edge<Integer> follower : followers1) {
                                Vertex followerVertex = FoeBook.opposite(user7, follower);
                                count1++;
                            }
                            System.out.println("Number of followers: "+count1);
                            break;
                        case 12:
                            System.out.println("Enter the name of user 1: ");
                            String userName8 = sc.nextLine();
                            Vertex user8 = null;
                            for(Vertex v : FoeBook.vertices()){
                                if(v.getElement().equals(userName8)){
                                    System.out.println(v.getElement());
                                    user8 = v;
                                    break;
                                }
                                else{
                                    System.out.println("User not found");
                                }
                            }
                            System.out.println("Enter the name of user 2: ");
                            String userName9 = sc.nextLine();
                            Vertex user9 = null;
                            for(Vertex v : FoeBook.vertices()){
                                if(v.getElement().equals(userName9)){
                                    user9 = v;
                                }
                                else{
                                    System.out.println("User not found");
                                }
                            }
                            System.out.println("Enter the friendship level between " + user8.getElement() + " and " + user9.getElement() + ": ");
                            int friendshipLevel = sc.nextInt();
                            sc.nextLine(); // Consume the newline character
                            FoeBook.insertEdge(user8, user9, friendshipLevel);
                            break;
                        case 13:
                            System.out.println("Enter the name of user 1: ");
                            String userName10 = sc.nextLine();
                            Vertex user10 = null;
                            Vertex user11 = null;
                            for(Vertex v : FoeBook.vertices()){
                                if(v.getElement().equals(userName10)){
                                    System.out.println(v.getElement());
                                    user10 = v;
                                    break;
                                }
                                else{
                                    System.out.println("User not found");
                                }
                            }
                            System.out.println("Enter the name of user 2: ");
                            String userName11 = sc.nextLine();
                            for(Vertex v : FoeBook.vertices()){
                                if(v.getElement().equals(userName11)){
                                    user11 = v;
                                }
                                else{
                                    System.out.println("User not found");
                                }
                            }
                            System.out.println("Enter the friendship level between " + user10.getElement() + " and " + user11.getElement() + ": ");
                            int friendshipLevel1 = sc.nextInt();
                            sc.nextLine(); // Consume the newline character
                            FoeBook.insertEdge(user10, user11, friendshipLevel1);
                            break;
                        case 14:
                            // exit case
                            System.out.println("Exiting...");
                            System.out.println("Thank you for using FoeBook!");
                            break;
                        default:
                            System.out.println("Invalid choice");
                            break;
                        }
                        
                    
                }
            }
                }

    private static void analyzeFoeBook(Graph<Integer> FoeBook) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the name of the user to analyze: ");
        String userName = sc.nextLine();
        Vertex user = null;
        for(Vertex v : FoeBook.vertices()){
            if(v.getElement().equals(userName)){
                System.out.println(v.getElement());
                user = v;
                break;
            }
            else{
                System.out.println("User not found");
            }
        }
        // Display friends of the user
        List<Edge<Integer>> friends = FoeBook.outgoingEdges(user);
        System.out.println(user.getElement() + "'s Friends:");
        for (Edge<Integer> friend : friends) {
            Vertex friendVertex = FoeBook.opposite(user, friend);
            System.out.println("- " + friendVertex.getElement() + " (Friendship Level: " + friend.getWeight() + ")");
        }
        System.out.println();

        // Display common friends between two users
        System.out.print("Enter the name of another user: ");
        String otherUserName = sc.nextLine();
        Vertex otherUser = new Vertex(otherUserName);

        List<Edge<Integer>> commonFriends = findCommonFriends(FoeBook, user, otherUser);
        System.out.println("Common Friends between " + user.getElement() + " and " + otherUser.getElement() + ":");
        for (Edge<Integer> commonFriend : commonFriends) {
            Vertex commonFriendVertex = FoeBook.opposite(user, commonFriend);
            System.out.println("- " + commonFriendVertex.getElement() + " (Friendship Level: " + commonFriend.getWeight() + ")");
        }
    }

    private static List<Edge<Integer>> findCommonFriends(Graph<Integer> FoeBook, Vertex user1, Vertex user2) {
        List<Edge<Integer>> commonFriends = new ArrayList<>();
        List<Edge<Integer>> friends1 = FoeBook.outgoingEdges(user1);
        List<Edge<Integer>> friends2 = FoeBook.outgoingEdges(user2);

        for (Edge<Integer> friend1 : friends1) {
            for (Edge<Integer> friend2 : friends2) {
                if (friend1.getDest().equals(friend2.getDest())) {
                    commonFriends.add(friend1);
                }
            }
        }

        return commonFriends;
    }
}
