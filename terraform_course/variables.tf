variable "bucket_name" {
  description = "Bucket name for S3"
}

resource "aws_s3_bucket" "variable_s3_bucket" {
  bucket = var.bucket_name == "" ? "yury-s3-bucket" : var.bucket_name
}

locals {
  instance_name = "dev-instance"
  instance_type = "t2.micro"
}

resource "aws_instance" "my_instance" {
  ami           = "ami-423432fdsf"
  instance_type = local.instance_type

  tags = {
    Name = local.instance_name
  }
}

variable "vpc_cidr_block" {
  default = "10.0.0.0/16"
  description = "VPC CIDR Block"
}

variable "public_subnet_cidr" {
  default = "10.0.1.0/24"
  description = "Public Subnet CIDR"
}

variable "private_subnet_cidr" {
  default = "10.0.2.0/24"
  description = "Privet Subnet CIDR"
}
