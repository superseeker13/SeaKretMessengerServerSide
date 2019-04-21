import os
import imageio
import sys


png_dir = sys.argv[1] + '/'
os.chdir(sys.argv[1])
images = []
savePath = png_dir + "test.txt"
file = open("test.txt", "w")
file.writeLine("Did this work or not")
file.close()