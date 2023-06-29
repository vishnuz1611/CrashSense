# CrashSense
CrashSense is an innovative project aimed at enhancing road safety by leveraging advanced computer vision techniques. CrashSense detects accidents in real-time by analyzing video footage captured from various sources such as dashcams, surveillance cameras, or smartphones.

## Description
This project is an accident alert system that combines computer vision methodologies and deep learning algorithms to detect and respond to accidents in real-time. The system utilizes CCTV footage as the primary data source, leveraging the capabilities of the YOLOv8 object detection model to accurately identify accidents. By analysing the video stream, the system can rapidly detect and localize accidents, providing crucial details such as accident clips, geographical coordinates, and timestamps. The detected accident information is then transmitted to a dedicated mobile application, enabling immediate alert notifications to be sent to relevant authorities & emergency services.

## Parts of the Application
The system consists of 3 key components: Firebase for database management, a server for processing incoming videos to detect accidents, and a mobile application for alerting users about accidents and providing relevant details.
* #### Server - https://github.com/vishnuz1611/CrashSense-prediction
* #### Mobile App - https://github.com/vishnuz1611/CrashSense

![image](https://github.com/vishnuz1611/CrashSense/assets/64272628/35c5efa5-17ae-4af9-9d79-8ca0c14342f9)


## Installation of project
* Open Android Studio, click File --> New --> Project from Version Control.
* Choose Git from the Version control dropdown.
* Copy the hyperlink present when you click on the Code button in the repository and paste in the URL tab.
* Click Clone.
* Sync project and run.
* Clone the Server repo and run it on a machine on the side

## Results
![image](https://github.com/vishnuz1611/CrashSense/assets/64272628/5ca96037-6c5d-4ca6-bb58-19d460a5ad3e)  ![image](https://github.com/vishnuz1611/CrashSense/assets/64272628/dde60a30-c25c-44a2-a6d4-97660556d9fd)

![image](https://github.com/vishnuz1611/CrashSense/assets/64272628/864bf28d-2140-405b-baf5-6b5c79426409)
* Server predicts accidents from the uploaded videos and if accident is detected, the accident data is sent to firebase database
  
![image](https://github.com/vishnuz1611/CrashSense/assets/64272628/7285fced-c15e-43c6-881a-021d7d54030c)
![image](https://github.com/vishnuz1611/CrashSense/assets/64272628/f8d57f41-9dfc-4922-aed7-c2068f38edb0)
* Information from firebase is retrieved onto the mobile application and the alert is displayed
  
![image](https://github.com/vishnuz1611/CrashSense/assets/64272628/720280dc-ec98-4d0e-9e78-466ecfdfd813)  ![image](https://github.com/vishnuz1611/CrashSense/assets/64272628/4d80fb5f-1597-4526-b731-ef90e19227d9)






