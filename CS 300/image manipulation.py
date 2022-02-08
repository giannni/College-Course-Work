from PIL import Image, ImageDraw, ImageFont, ImageFilter
# open both images and paste image 2 on 1
image1 = Image.open('deer.jpg')
image2 = Image.open('flowers.jpg')
image2 = image2.resize((200,150))
image3 = image1.copy()
# create a mask for blurring
mask = Image.new("L", image2.size, Image.ANTIALIAS)
draw = ImageDraw.Draw(mask)
w, h = 300, 300
shape = [(40, 40), (w - 10, h - 10)]
draw.rectangle(shape, fill=255)
image3.paste(image2, (130, 275), mask)
# Strings to name the pictures
deer = "Deer, Cervidae-Cervinae"
flower = "Peony, Paeonia"
# Draw text on image 3 and set fonts
draw = ImageDraw.Draw(image3)
font = ImageFont.truetype('tahoma', 16)
draw.text((500, 175), deer, (255,255,255), font)
draw.text((200, 275), flower, (255,255,255), font)
# Save image and show it
image3.save('final.png')
image3.show()
