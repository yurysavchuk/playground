provider "aws" {
  region = "us-west-2"
}

terraform {
  backend "s3" {
    bucket = "tf-12-remote-states"
    key = "aws_tf_remote_state.tfstates"
    region = "us-west-2"
  }
}

resource "aws_s3_bucket" "terraform_remote_state_bucket" {
  bucket = "tf-12-remote-states"
  region = "us-west-2"
}

resource "aws_security_group" "security_group" {
  ingress {
    from_port = 22
    protocol = "TCP"
    to_port = 22
    cidr_blocks = ["0.0.0.0/0"]
  }

  egress {
    from_port = 0
    protocol = "TCP"
    to_port = 0
    cidr_blocks = ["192.168.1.1/32"]
  }

  tags = {
    Name="AWS_SG"
  }
}
