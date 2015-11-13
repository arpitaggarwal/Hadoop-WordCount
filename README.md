# hadoop-wordcount


### Usage:

**Step 1:** Download [Cloudera Quick Start VM][1]

**Step 2:** Run the VM and open the terminal and execute command:

```sudo /home/cloudera/cloudera-manager --force```

It will launch Cloudera Manager and all the Hadoop related deamons.

**Step 3:** Edit Build path with hadoop dependent jars present in hadoop client folder, for Cloudera VM it's (usr/lib/hadoop/client).

**Step 4:** Export the project as jar file and place it any folder. For me it's my Cloudera VM Desktop.

**Step 5:** Open the browser window from Cloudera VM screen and click on ```Hue``` (bookmarked) then click on File Browser butoon and put any file for which you want to calculate word count in it, for me it's data.txt. With this we put a file in HDFS and Hadoop by default takes it's input from HDFS.

**Step 6:** Open the Terminal and execute the below command:

```sudo -u hdfs hadoop jar /home/cloudera/Desktop/wordcount.jar com.test.WordCount /user/cloudera/data.txt /home/cloudera/Desktop/```

After executing above command, we can see the output in Terminal and we can see in HDFS using Hue as Hadoop by default create output file in HDFS.

[1]:http://www.cloudera.com/content/www/en-us/documentation/enterprise/latest/topics/cloudera_quickstart_vm.html
