# gtfs-validator [![Test Package Document](https://github.com/MobilityData/gtfs-validator/workflows/Test%20Package%20Document/badge.svg)](https://github.com/MobilityData/gtfs-validator/actions?query=workflow%3A%22Test+Package+Document%22) ![End to end](https://github.com/MobilityData/gtfs-validator/workflows/End%20to%20end/badge.svg) ![End to end big](https://github.com/MobilityData/gtfs-validator/workflows/End%20to%20end%20big/badge.svg) ![End to end 100](https://github.com/MobilityData/gtfs-validator/workflows/End%20to%20end%20100/badge.svg) [![Rule acceptance tests](https://github.com/MobilityData/gtfs-validator/actions/workflows/acceptance_test.yml/badge.svg)](https://github.com/MobilityData/gtfs-validator/actions/workflows/acceptance_test.yml) ![Docker image](https://github.com/MobilityData/gtfs-validator/actions/workflows/docker.yml/badge.svg) [![Join the gtfs-validator chat](https://badgen.net/badge/slack/%20/green?icon=slack)](https://bit.ly/mobilitydata-slack)

A GTFS Schedule (static) [General Transit Feed Specification (GTFS)](https://gtfs.mobilitydata.org/spec/gtfs-schedule) feed validator

This README contains information for the master branch of this project, which is under active development. If you'd like to view documentation for past releases of the project, see:
* [v1.4.0](https://github.com/MobilityData/gtfs-validator/blob/v1.4.0-docs/README.md)
* [v2.0.0](https://github.com/MobilityData/gtfs-validator/blob/v2.0.0-docs/README.md)
* [v3.0.0](https://github.com/MobilityData/gtfs-validator/blob/docs/v3.0.0/README.md)

# Introduction
This is a command-line tool written in Java that performs the following steps:
1. Loads input GTFS zip file from a URL or disk
1. Checks file integrity, numeric type parsing and ranges as well as string format according to the [GTFS Schedule specification](https://gtfs.mobilitydata.org/spec/gtfs-schedule#h.hc443y62gb8c)
1. Performs GTFS [business rule validation](/RULES.md)

# Run the app via command line
### Setup
1. Install [Java 11 or higher](https://www.oracle.com/java/technologies/javase-downloads.html). To check which version of Java is installed on your computer, type the following command in the terminal: `java --version`.
2. Download the latest snapshot jar of the validator from the artifacts generated by the [`Test Package Document`](https://github.com/MobilityData/gtfs-validator/actions/workflows/test_pack_doc.yml) workflow.
See detailed instructions [here](/docs/DOWNLOAD_SNAPSHOT_JAR.md).
3. Open the terminal on your computer
4. Navigate to the directory containing the jar file. You can do this by typing the following command in the terminal:`cd [insert path to the directory]`. You can then make sure you're in the right directory by typing `pwd` in the terminal (this stands for *present working directory*). You can also make sure the jar file is there by typing `ls` in the terminal (this stands for *list* and will display the list of files in this directory). More about commands to navigate file and directories [here](https://help.ubuntu.com/community/UsingTheTerminal#File_.26_Directory_Commands). 

### Run it
You can run this validator using a GTFS dataset on your computer, or from a URL. 
- To validate a GTFS dataset on your computer, run the following command in the terminal, replacing the text in brackets:
  - `java -jar [name of the jar file] -i [path to the GTFS file] -o [name of the output directory that will be created]`
  - here is an example of what the command could look like:  `java -jar gtfs-validator-v-snapshot_cli.jar -i /myDirectory/gtfs.zip -o output`

- To validate a GTFS dataset from a URL, run the following command in the terminal, replacing the text in brackets:
  - `java -jar [name of the jar file] -u [URL to the GTFS file] -o [name of the output directory that will be created] -c ca`
  - here is an example of what the command could look like: `java -jar gtfs-validator-v-snapshot_cli.jar -u https://www.abc.com/gtfs.zip -o output`

More detailed instructions with all the parameters that exists are available on our ["Usage"](/docs/USAGE.md) page.

# Run the app using Docker
### Setup
1. Download and install [Docker](https://docs.docker.com/get-started/)
1. Pull the [latest Docker image for this project](https://github.com/orgs/MobilityData/packages/container/package/gtfs-validator). For example, `docker pull ghcr.io/mobilitydata/gtfs-validator` for the latest snapshot version of the validator.

### Run it

#### For Mac and Linux

To run the Docker image in a new container:

`docker run -v /myDirectory:/theContainerDirectory -it ghcr.io/mobilitydata/gtfs-validator:latest`

where:
* `-v /myDirectory:/theContainerDirectory`: syntax to share directories and data between the container and the host (your computer). With the above command, any files that you place in `/myDirectory` on the host will show up in `/theContainerDirectory` inside the container and vice versa.

***NOTE:*** On Windows, you must provide the local volume (e.g., `c:`) as well:

`... c:/myDirectory:/theContainerDirectory ...`

The validator can then be executed via bash commands. See the [preceeding instructions for command line usage](#run-the-app-via-command-line).

# Validation rules
* [Implemented rules](/RULES.md)

Possible future rules for:
* [GTFS Reference](https://github.com/MobilityData/gtfs-validator/labels/Rules%20-%20GTFS%20Reference)
* [GTFS Best Practices](https://github.com/MobilityData/gtfs-validator/labels/Rules%20-%20GTFS%20Best%20Practices)
* [Community rules](https://github.com/MobilityData/gtfs-validator/labels/Rules%20-%20Community%20rules)

Have a suggestion for a new rule? Open [an issue](https://github.com/MobilityData/gtfs-validator/issues/new/choose). You can see the complete process for adding new rules on the ["Adding new rules"](/docs/NEW_RULES.md) page.

# Build the code
We suggest using [IntelliJ](https://www.jetbrains.com/idea/download/) to [import](https://www.jetbrains.com/help/idea/import-project-or-module-wizard.html), build, and run this project.

Instructions to build the project from the command-line using [Gradle](https://gradle.org/) are available in our [Build documentation](/docs/BUILD.md).

# Architecture
The architecture of the `gtfs-validator` is described on our [Architecture page](/docs/ARCHITECTURE.md).

# Acceptance tests
In order to avoid sudden changes in the validation output that might declare previously valid datasets invalid, all code changes in pull requests are tested against GTFS datasets in the [MobilityDatabase](http://old.mobilitydatabase.org/wiki/Main_Page). The acceptance test process is described in [ACCEPTANCE_TESTS.md](docs/ACCEPTANCE_TESTS.md).

# License
Code licensed under the [Apache 2.0 License](http://www.apache.org/licenses/LICENSE-2.0).

# Contributing
We welcome contributions to the project! Please check out our [Contribution guidelines](/docs/CONTRIBUTING.md) for details. 
