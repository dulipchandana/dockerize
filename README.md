# dockerize
dockerize a java mickro services (spring boot or dropwizard ) 
docker info

docker run --to run a new container

docker ps --to see running and stopped containers

docker images to see info about images

--How docker workes--------

1.installing Docker gives you the client and deamon

2.Client makes API calles to daemon

3.Daemon implements the Docker Remote API

4.docker run starts a new container

5.Docker Hub is the public registry

6.The daemon will pull images that it doesn't already have 

Images ~ Stopped containers 

Containers ~ Running Images 

--how pull a image from docker hub--

docker pull <image name>

eg : docker pull alpine 

---remove a image ----


docker rmi <image name>

eg: docker rmi alpine

docker lifecycle

docker start <container>

docker stop <container>

docker rm <container>

---stop all docker containers ---

docker stop $(docker ps -aq)

docker rm $(docker ps -aq) --remove all images

swarm mode theory
-----------------

A cluster = A swarm
1.Engines in a swarm run in swarm mode

2. Manager nodes maintain the swarm
   # H/A - recommended 3 or 5
   # Only one is leader 
3. Worker nodes execute tasks

4. Services - Declarative  & scalable

5.Tasks ~ containers
  #assign to worker nodes

build a swarm
-------------

docker swarm init --advertise-addr 127.0.0.1:2377 --listen-addr 127.0.0.1:2377

# Engine port : 2375
# Secure Engine port : 2376
# Swarm port : 2377
--------------responce from swrm init ---------------------
Swarm initialized: current node (g113u50bs8du3wiom8b4j5xtg) is now a manager.

To add a worker to this swarm, run the following command:

    docker swarm join --token SWMTKN-1-0gqt4v2whj8zplb8nt9bunjfe2wngns4h41zkxmuwavpvcf7ck-a4zoeshfmujxaehjq86yu0cbk 127.0.0.1:2377

To add a manager to this swarm, run 'docker swarm join-token manager' and follow the instructions.

-----------------------------------------------------------


docker swarm join-token worker


docker -info
---------------------responce-------------------

Swarm: active
 NodeID: g113u50bs8du3wiom8b4j5xtg
 Is Manager: true
 ClusterID: qjmhfca95ypl8lp8qgb81x40u
 Managers: 1
 Nodes: 1
 Orchestration:
  Task History Retention Limit: 5
 Raft:
  Snapshot Interval: 10000
  Number of Old Snapshots to Retain: 0
  Heartbeat Tick: 1
  Election Tick: 3
 Dispatcher:
  Heartbeat Period: 5 seconds
 CA Configuration:
  Expiry Duration: 3 months
  Force Rotate: 0
 Root Rotation In Progress: false
 Node Address: 127.0.0.1
 Manager Addresses:
  127.0.0.1:2377
-------------------------

docker node -ls --can only run in manager 

----------------link manager and worker node ---

docker swarm join --token SWMTKN-1-0gqt4v2whj8zplb8nt9bunjfe2wngns4h41zkxmuwavpvcf7ck-a4zoeshfmujxaehjq86yu0cbk 127.0.0.1:2377 \
--advertise-addr <cluster2.addr:port> \
--listen-addr <cluster2.addr:port>

docker swarm join --token SWMTKN-1-0gqt4v2whj8zplb8nt9bunjfe2wngns4h41zkxmuwavpvcf7ck-a4zoeshfmujxaehjq86yu0cbk 127.0.0.1:2377 \
--advertise-addr <27.0.0.2:2377> \
--listen-addr <27.0.0.2:2377>


docker node promote g113u50bs8du3wiom8b4j5xtg   ---promote worker to a manager

-----Services------------------

docker service create --name <name-container> -p 8080:8080 --replicas <number_of_replications> <image-path>


































