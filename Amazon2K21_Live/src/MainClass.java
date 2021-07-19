//
//public class MainClass {
//	/*
//	*A PackageBundle is a file describing a set of packages that work well together. It's a text file of the following structure: 
//
//	<package_name> <version> <commit> 
//	<unique> 
//	Write an application that, when given two PackageBundles (old and new), prints a list of: 
//	1) New packages. 
//	2) Packages whose version was increased. 
//	3) Packages whose version was downgraded. 
//	4) Packages of the same version, but with different commits.
//	*/
//
//	public class PackageBundle {
//	    private String packageName;
//	    private long version;
//	    private String commit;
//	    
//	    // getter setter
//	}
//
//	public void printPacakgeDiffernce(Map<String, PackageBundle> oldBundle, Map<String, PackageBundle> newBundle) {
//	    if(Objects.isNull(oldBundle) || oldBundle.isEmpty || Objects.isNull(newBundle) || newBundle.isEmpty) {
//	        return;
//	    }
//	    //1.2.32 1.2.31
//	    // Keys N O(N) + N = 2N = N, O(N)
//	    Set<String> commonKeys = oldBundle.keys().stream().filter(key -> newBundle.containsKey(key)).collect(Collectors.toSet());
//	    commonKeys.foreach(key -> {
//	       if(oldBundle.get(key).getVersion() > newBundle.get(key).getVersion()) {
//	           System.out.prinln("Downgraded : "+ newBundle.get(key));
//	       } else if (oldBundle.get(key).getVersion() < newBundle.get(Key).getBundle()) {
//	           System.out.prinln("Upgraded : "+ newBundle.get(key));
//	       } else if (oldBundle.get(key).getVersion() == newBundle.get(Key).getBundle() && !oldBundle.get(key).getCommit.equals(newBundle.get(Key).getCommit())){
//	           System.out.prinln("Commit different : "+ newBundle.get(key));
//	       }
//	        
//	    });
//	    
//	    Set<String> distictKeys = newBundle.keys().stream().filter(key -> !commonkeys.contains(key)).collect(Collectors.toSet());
//	    if(!distickeys.isEmpty()) {
//	        distictkeys.forEach(key -> {
//	            System.out.prinln("new Bundle : "+ newBundle.get(key));
//	        });
//	    }
//	    
//	}
//
//	"1.4.67"
//public static void main(String[] args) {
//
//}
//}
