// it is commented because it causes issues during 'terraform plan' command execution
//resource "aws_instance" "ec_instance" {
//  ami = "ami-43242fsd"
//  instance_type = "t2.micro"
//  key_name = data.aws_instance.ec2_data.key_name

//  tags = {
//    Name="niyazi-ec2-instance"
//  }
//}

//data "aws_instance" "ec2_data" {
//  instance_id = "54542gfdg"
//}

//data "aws_vpc" "default_vpc" {
//  cidr_block = "10.0.0.0/16"
//}
