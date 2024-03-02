#!/bin/bash

# Installing Dependencies
echo "########################################"
echo "Installing packages."
echo "########################################"
sudo apt update -y > /dev/null
sudo apt install wget unzip apache2 -y > /dev/null
echo

# Creating Temp Directory
echo "########################################"
echo "Starting Artifact Deployment"
echo "########################################"
mkdir -p /tmp/webfiles
cd /tmp/webfiles
echo

wget https://www.tooplate.com/zip-templates/2133_moso_interior.zip > /dev/null
unzip 2133_moso_interior.zip > /dev/null
sudo cp -r 2133_moso_interior/* /var/www/html/
echo

# Bounce Service
echo "########################################"
echo "Restarting Apache Webserver service"
echo "########################################"
sudo systemctl restart apache2
echo

# Clean Up
echo "########################################"
echo "Removing Temporary Files"
echo "########################################"
sudo rm -rf /tmp/webfiles
echo