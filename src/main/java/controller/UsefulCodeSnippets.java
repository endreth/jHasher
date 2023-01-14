package controller;

public class UsefulCodeSnippets {

    /* -------------------------------------------------------------------------------------------------------------- */
    /* USEFUL CODE SNIPPETS */

//    /**
//     * Adjust textArea size dynamically according to the stage size
//     * @param primaryStage
//     */
//    public void start(Stage primaryStage) {
//        pStage.widthProperty().addListener(new ChangeListener<Number>() {
//
//            @Override
//            public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue) {
//                // To check if it is working:
//                // System.out.println("Size changed! Original size: "+oldValue.intValue()+", new size: "+ newValue.intValue() + ")\n");
//                gc.taInput.setPrefWidth(newValue.doubleValue() - 55);
//            }
//        });
//        pStage.widthProperty().addListener((obs, oldVal, newVal) -> {
//            System.out.println("Size changed! " + oldVal.intValue() + ", new size: " + newVal.intValue() + ")\n");
//        });
//    }


//    /**
//     *  Bind textarea to stage, take up only 80%
//     */
//    this.taInput.prefHeightProperty().bind(Bindings.divide(view.GUI.getpStage().maxHeightProperty(),80));
//	  this.taInput.prefWidthProperty().bind(Bindings.divide(view.GUI.getpStage().maxWidthProperty(),80));


//    /**
//     * List algorithm providers 1
//     */
//    public void ListProviders1(){
//        Provider[] sarr = Security.getProviders();
//        for (Provider provider : sarr) {
//            System.out.println(provider.getName());
//        }
//    }
//
//    /**
//     * List algorithm providers 2
//     * https://flylib.com/books/en/1.274.1/appendix_b_algorithms_provided_by_the_bouncy_castle_provider.html
//     * The following digests are supported: GOST3411, MD2, MD4, MD5,
//     * RIPEMD128, RIPEMD160, RIPEMD256, RIPEMD320, SHA1, SHA224, SHA256, SHA384, SHA512, Tiger, and Whirlpool.
//     */
//    public void ListProviders2(){
//        Security.addProvider(new BouncyCastleProvider());
//        for (Provider provider: Security.getProviders()) {
//            System.out.println(provider.getName());
//            for (Provider.Service s: provider.getServices()){
//                if (s.getType().equals("Cipher"))
//                    System.out.println("\t"+s.getType()+" "+ s.getAlgorithm());
//            }
//        }
//    }
//
//    /**
//     * List algorithm providers 3
//     * @return list of providers
//     */
//    public static List<String> getAvailableAlgorithms() {
//        final String digestClassName = MessageDigest.class.getSimpleName();
//        final String aliasPrefix = "Alg.Alias." + digestClassName + ".";
//
//        return Arrays.stream(getProviders())
//                .flatMap(prov -> {
//                    final Set<String> algorithms = new HashSet<>(0);
//
//                    prov.getServices().stream()
//                            .filter(s -> digestClassName.equalsIgnoreCase(s.getType()))
//                            .map(Provider.Service::getAlgorithm)
//                            .collect(Collectors.toCollection(() -> algorithms));
//
//                    prov.keySet().stream()
//                            .map(Object::toString)
//                            .filter(k -> k.startsWith(aliasPrefix))
//                            .map(k -> String.format("\"%s\" -> \"%s\"", k.substring(aliasPrefix.length()), prov.get(k).toString()))
//                            .collect(Collectors.toCollection(() -> algorithms));
//
//                    return algorithms.stream();
//                })
//                .sorted(String::compareTo)
//                .collect(Collectors.toList());
//    }
//
//    /**
//     *  Test implemented algorithms
//     */
//    public static void algorithmTests(){
//
//        AbstractFactory fp = FactoryProducer.getFactory(false); // If FALSE, hash without salt generated
//        HashType MD2 = fp.getHashType("MD2");
//        HashInput hi = new HashInput("ide_jon_a_szoveg_amit_hashelunk");
//        String hashed_text = MD2.encrypt(hi.inputparser("TXT"));
//        System.out.println("Hashed without salt: "+hashed_text);
//
//        System.out.println("-----------------------------------------------");
//
//        AbstractFactory fp2 = FactoryProducer.getFactory(true); // If TRUE, hash with salt generated
//        HashType MD2_2 = fp2.getHashType("MD2");
//        HashInput hi2 = new HashInput("ide_jon_a_szoveg_amit_hashelunk");
//        String hashed_text2 = MD2_2.encrypt(hi2.inputparser("TXT"));
//        System.out.println("Hashed with salt: "+hashed_text2);
//
//        System.out.println("-----------------------------------------------");
//
//        AbstractFactory fp3 = FactoryProducer.getFactory(false);
//        HashType crc = fp3.getHashType("CRC32");
//        HashInput input = new HashInput("Hello_CRC32");
//        System.out.println("CRC32 szöveg: "+crc.encrypt(input.inputparser("TXT")));
//
//        System.out.println("-----------------------------------------------");
//
//        AbstractFactory fp4 = FactoryProducer.getFactory(false);
//        HashType base64 = fp4.getHashType("Base64");
//        HashInput inp = new HashInput("Hello_Base64!!!");
//        System.out.println("Base64 szöveg: "+base64.encrypt(inp.inputparser("TXT")));
//
//        System.out.println("-----------------------------------------------");
//
//        AbstractFactory fp5 = FactoryProducer.getFactory(false);
//        HashType blake3 = fp5.getHashType("Blake3");
//        HashInput i = new HashInput("Hello_Blake3!!!");
//        System.out.println("Blake3 hash: "+blake3.encrypt(i.inputparser("TXT")));
//
//        AbstractFactory fp6 = FactoryProducer.getFactory(true);
//        HashType blake3s = fp6.getHashType("Blake3");
//        HashInput is = new HashInput("Hello_Blake3!!!");
//        System.out.println("Blake3 hash sózott: "+blake3s.encrypt(is.inputparser("TXT")));
//
//        System.out.println("-----------------------------------------------");
//
//        System.out.println("Blake2b hash: "+ FactoryProducer.getFactory(false).getHashType("Blake2b").encrypt(new HashInput("Hello_Blake2b!!!").inputparser("TXT")) );
//        System.out.println("Blake2b hash sózott: "+ FactoryProducer.getFactory(true).getHashType("Blake2b").encrypt(new HashInput("Hello_Blake2b!!!").inputparser("TXT")) );
//
//        System.out.println("-----------------------------------------------");
//
//        System.out.println("SHA-1 hash: "+ FactoryProducer.getFactory(false).getHashType("SHA-1").encrypt(new HashInput("Hello_SHA-1!").inputparser("TXT")) );
//    }


//    /**
//     * ThreadTest class
//     */
//    public class ThreadTest {
//        //private ComboBox<Integer> cbThreads;
//        private ArrayList<String> list = new ArrayList<>();
//
//
//        public ThreadTest(/*ComboBox<Integer> cbThreads*/) {
//            /*this.cbThreads = cbThreads;*/
//            this.list.addAll(Arrays.asList("one","two","three"));
//        }
//
//        public void parallelize() throws InterruptedException, ExecutionException {
//
//            int nthreads = 6; /*this.cbThreads.getSelectionModel().getSelectedItem();*/ // For example, user will choose 6 for the number of threads
//            ExecutorService threadPool = Executors.newFixedThreadPool(nthreads); // create a thread pool with 6 threads (workers)
//
//            List<Callable<String>> callableTasks = new ArrayList<>();
//            StopWatch watch = new StopWatch();
//            watch.start();
//            this.list.forEach(n->{
//
//                Callable<String> callableTask = () -> {
//                    //This is just an example
//                    TimeUnit.MILLISECONDS.sleep(300);
//                    String word_length = String.valueOf(n.length());
//                    String name = Thread.currentThread().getName();
//                    String result = "Task's execution: "+name+", length of word "+n+": "+word_length;
//                    return result;
//                };
//                callableTasks.add(callableTask);
//
//            });
//
//
//            List<Future<String>> futures = threadPool.invokeAll(callableTasks);
//            watch.stop();
//            // After submitting my tasks, I'll shut down the threadpool
//            threadPool.shutdown();
//
//            //I need my results in the order as they are in the original list!
//            for (Future<String> future : futures) {
//                String result = future.get();
//                System.out.println(result);
//            }
//
//
//
//            long ms = watch.getTotalTimeMillis();
//            float sec = ms / 1000.0f;
//            String s = String.format("%.5f", sec);
//            System.out.println(Long.toString(ms) + "ms " + "[" + s + "sec]");
//
//        }

//     public void writeOutFilePaths(){
//          String pathStringToAFile = "U:\\temp\\TestOutput\\TestFolder\\test_file.txt";
//          String pathStringToAFolder = "U:\\temp\\TestOutput\\TestFolder";
//          String pathStringToAFolderWithTrailingBackslash = "U:\\temp\\TestOutput\\TestFolder\\";
//
//          Path pathToAFile = Paths.get(pathStringToAFile);
//          Path pathToAFolder = Paths.get(pathStringToAFolder);
//          Path pathToAFolderWithTrailingBackslash
//            = Paths.get(pathStringToAFolderWithTrailingBackslash);
//
//          System.out.println(pathToAFile.getFileName().toString()); // test_file.txt
//          System.out.println(pathToAFolder.getFileName().toString()); // TestFolder
//          System.out.println(pathToAFolderWithTrailingBackslash.getFileName().toString()); // TestFolder
//      }



    /* -------------------------------------------------------------------------------------------------------------- */

















}
